package com.nems.ctx.ms.submission.domainevents;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by NE281900 on 5/8/2016.
 */
public interface Sender {
    String SENDER_CHANNEL="output";
    @Output(Sender.SENDER_CHANNEL)
    MessageChannel send();
}
