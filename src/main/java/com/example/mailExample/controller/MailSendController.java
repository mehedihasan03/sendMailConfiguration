package com.example.mailExample.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mailExample.model.MailModal;
import com.example.mailExample.service.EmailService;

@RestController
public class MailSendController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/sendMail")
	public ResponseEntity<?> sendMail(@RequestBody MailModal payload){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			emailService.sendMail(payload);
			map.put("status", "success");
			return ResponseEntity.status(HttpStatus.OK).body(map);
		} catch (Exception e) {
			map.put("status", "failed");
			map.put("message", e.getLocalizedMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
}
