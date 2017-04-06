package com.omexit.mifospaymentbridge.services.channel;

import com.omexit.mifospaymentbridge.domain.channel.Channel;

import java.util.List;

/**
 * Created by Antony on 2/14/2016.
 */
public interface ChannelService {
    Channel saveOrUpdateChannel(Channel channel);
    Channel findChannelByChannelName(String channelName) ;
    Channel findchannelbyId(Long channelId);
    List<Channel> findAllChannels();
}
