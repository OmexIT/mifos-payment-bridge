package com.omexit.mifospaymentbridge.services.channel;

import com.omexit.mifospaymentbridge.domain.channel.Channel;

import java.util.List;

/**
 * Created by Antony on 2/14/2016.
 */
public interface ChannelService {
    /**
     * Save or update Channel
     *
     * @param channel
     * @return
     */
    Channel saveOrUpdateChannel(Channel channel);

    /**
     * Method to find channel by channel name
     *
     * @param channelName name of the channel
     * @return
     */
    Channel findChannelByChannelName(String channelName) ;

    /**
     * Find Channel by name
     *
     * @param channelId
     * @return
     */
    Channel findchannelbyId(Long channelId);

    /**
     * Returns all channels
     *
     * @return
     */
    List<Channel> findAllChannels();
}
