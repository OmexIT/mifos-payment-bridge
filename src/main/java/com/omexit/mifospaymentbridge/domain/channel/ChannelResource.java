package com.omexit.mifospaymentbridge.domain.channel;

import org.springframework.hateoas.Resource;

/**
 * Created by aomeri on 3/24/17.
 */
public class ChannelResource extends Resource<Channel> {
    public ChannelResource(Channel content) {
        super(content);
    }
}
