package com.ezen.springmvc.web.chat.controller;

import com.ezen.springmvc.domain.chat.dto.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class ChatController {

    private static final Logger log = LoggerFactory.getLogger(ChatController.class);
    private final SimpMessageSendingOperations messagingTemplate;


    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        log.info("메세지 정보 {}", message.toString());
        if (ChatMessage.MessageType.ENTER.equals(message.getType()))
            message.setMessage(message.getSender() + "님이 입장하셨습니다.");

        messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }
}
