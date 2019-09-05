package com.slack.workspaceManager.controller;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slack.workspaceManager.service.workspaceService;

@RestController
@RequestMapping("/workspace")
public class workspaceController {

	@Autowired
	private workspaceService workspaceService;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private DirectExchange directExchange;
	
	@GetMapping("/send")
	public String sendMessage() {
		rabbitTemplate.convertAndSend(directExchange.getName(),"direct-key","This is a direct exchange message");
		return "message sent successfully!";
	}
	
	@GetMapping("/receive")
	public String receiveMessage() {
		Message message = rabbitTemplate.receive("directQueue");
		return new String(message.getBody());
	}
	
	@PostMapping
	public ResponseEntity<String> createWorkSpace(@ModelAttribute String  workspaceName) {
		if(workspaceService.addWorkspace(workspaceName))
			return new ResponseEntity<String>("Workspace Created", HttpStatus.OK);
		return new ResponseEntity<String>("Workspace not created", HttpStatus.NOT_ACCEPTABLE);
	}
	@PostMapping("/create-channel")
	public ResponseEntity<String> createChannel(@ModelAttribute String  channelName) {
		if(workspaceService.addChannel(channelName))
			return new ResponseEntity<String>("Workspace Created", HttpStatus.OK);
		return new ResponseEntity<String>("Workspace not created", HttpStatus.NOT_ACCEPTABLE);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteWorkSpace(@ModelAttribute String  workspaceName) {
		
		return new ResponseEntity<String>("Workspace not created", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-channel")
	public ResponseEntity<String> deleteChannel(@ModelAttribute String  workspaceName) {
		
		return new ResponseEntity<String>("Workspace not created", HttpStatus.OK);
	}
	
}
