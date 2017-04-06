package com.omexit.mifospaymentbridge.repository;

import com.omexit.mifospaymentbridge.domain.channel.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by omexic on 7/15/2015.
 */
@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {
    List<Channel> findAll();

    Channel findById(Long channelId);

    Channel findByChannelName(String channelName);
}
