package com.datawisher.bee.voice.controller;

import com.datawisher.bee.voice.model.VoiceModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author h407644
 * @date 2022-11-24
 */
@RestController
@RequestMapping("/voice")
public class VoiceController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/speak")
    public void speak(@RequestBody VoiceModel reqBody) {
        rabbitTemplate.convertAndSend("speaker.exchange", "speaker1", reqBody);
    }
}
