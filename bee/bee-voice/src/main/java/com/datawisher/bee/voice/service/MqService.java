package com.datawisher.bee.voice.service;

import com.datawisher.bee.voice.model.VoiceModel;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author h407644
 * @date 2022-11-25
 */
@Component
public class MqService {

    @Value("${voice.save}")
    private Boolean voiceSave;

    @Autowired
    private JacobVoiceService jacobVoiceService;

    @RabbitListener(bindings = {@QueueBinding(value = @Queue(value = "${voice.spot}", durable = "false"),
            exchange = @Exchange(value = "speaker.exchange"),
            key = "${voice.spot}")})
    public void processText(VoiceModel data) {
        try {
            jacobVoiceService.playVoice(data);
            if (voiceSave) {
                jacobVoiceService.saveVoice(data);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
