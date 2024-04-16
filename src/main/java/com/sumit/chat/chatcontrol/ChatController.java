package com.sumit.chat.chatcontrol;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
	
	
	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}
	
	 @MessageMapping("/chat.addUser")
	    @SendTo("/topic/public")
	public ChatMessage addUser(@Payload ChatMessage chatMessage,SimpMessageHeaderAccessor headeraccessor) {
		//add username in websocket session
		headeraccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
		
	}

}
