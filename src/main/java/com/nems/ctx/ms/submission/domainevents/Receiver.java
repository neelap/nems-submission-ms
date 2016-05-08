package com.nems.ctx.ms.submission.domainevents;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by NE281900 on 5/8/2016.
 */
public interface Receiver {
    String RECEIVER_CHANNEL = "input";
    @Input(Receiver.RECEIVER_CHANNEL)
    SubscribableChannel receive();
}
