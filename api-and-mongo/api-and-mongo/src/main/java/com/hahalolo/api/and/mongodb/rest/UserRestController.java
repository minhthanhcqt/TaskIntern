package com.hahalolo.api.and.mongodb.rest;

import java.util.Map;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hahalolo.api.and.mongodb.service.UserService;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/details")
	public ResponseEntity<Map<String, Object>> userDetails(@RequestParam(name = "id") String id) {
		Document userDetails = userService.findById(id);
		if (userDetails != null) {
			return ResponseEntity.ok(userDetails);
		}
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value="/create")
	public Map<String, String> createUser(@RequestBody Map<String, Object> map){  
		Document document=new Document(map);
			return userService.createUser(document);
	}
	@PostMapping(value="/verify")
	public Map<String , String> verifyAccountRegister(@RequestParam(name="id")String id, @RequestParam(name="otp")String otp){
		return userService.verifyUser(id, otp);
	}
	
	@PostMapping(value="/otp")
	public Map<String , String>sendOTP(@RequestParam(name="id")String id){
		return userService.sendcodeOTP(id);
	}
	@GetMapping(value="/login")
	public Map<String, Boolean>login(@RequestParam(name="username")String userName, @RequestParam(name="password")String password){
		return userService.userLogin(userName, password);
	}
}