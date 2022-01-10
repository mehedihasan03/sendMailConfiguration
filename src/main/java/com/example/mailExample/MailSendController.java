package com.example.mailExample;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
			
		} catch (Exception e) {
			map.put("status", "failed");
			map.put("message", e.getLocalizedMessage());
		}
		return ResponseEntity.ok(map);
	}
}
