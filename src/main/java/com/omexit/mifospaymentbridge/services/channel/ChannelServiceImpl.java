package com.omexit.mifospaymentbridge.services.channel;

import com.omexit.mifospaymentbridge.domain.channel.Channel;
import com.omexit.mifospaymentbridge.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Antony on 2/14/2016.
 */
@Service
public class ChannelServiceImpl implements ChannelService {
    private final ChannelRepository channelRepository;

    @Autowired
    public ChannelServiceImpl(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    @Override
    public Channel saveOrUpdateChannel(Channel channel) {
        String phoneNumberDefaultRegion = channel.getPhoneNumberDefaultRegion();
        if (phoneNumberDefaultRegion != null) {
            channel.setPhoneNumberDefaultRegion(phoneNumberDefaultRegion.toUpperCase());
        }
        channel = channelRepository.save(channel);
        channel = channelRepository.findById(channel.getId());
        return channel;
    }

    @Override
    public Channel findChannelByChannelName(String channelName) {
        Channel channel = channelRepository.findByChannelName(channelName);


        return channel;
    }

    @Override
    public Channel findchannelbyId(Long channelId) {
        return channelRepository.findById(channelId);
    }

    @Override
    public List<Channel> findAllChannels() {
        return channelRepository.findAll();
    }
}
