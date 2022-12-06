package com.datawisher.bee.voice.service;

import com.datawisher.bee.voice.model.VoiceModel;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author h407644
 * @date 2022-11-25
 */
@Component
public class MqService {

    private final JacobVoiceService jacobVoiceService;

    public MqService(JacobVoiceService jacobVoiceService) {
        this.jacobVoiceService = jacobVoiceService;
    }

    @RabbitListener(bindings = {@QueueBinding(value = @Queue(value = "${voice.spot}", durable = "false"),
            exchange = @Exchange(value = "speaker.exchange"),
            key = "${voice.spot}")})
    public void processText(@Payload VoiceModel voiceModel) {
        try {
            jacobVoiceService.playAndSaveVoice(voiceModel);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
