package com.omexit.mifospaymentbridge.domain.channel;


import com.omexit.mifospaymentbridge.controller.channel.ChannelController;
import com.omexit.mifospaymentbridge.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by aomeri on 23/03/2017.
 * @author Omeri Antony
 */
@Component
public class ChannelResourceAssembler implements ResourceAssembler<Channel, ChannelResource> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public ChannelResource toResource(Channel channel) {
        long channelId=channel.getId();
        ChannelResource channelResource=new ChannelResource(channel);
        try {
            channelResource.add(linkTo(methodOn(ChannelController.class).getChannelById(channelId)).withSelfRel());
        } catch (ResourceNotFoundException e) {
            logger.error(e.getMessage(),e);
        }
        return channelResource;
    }
}
