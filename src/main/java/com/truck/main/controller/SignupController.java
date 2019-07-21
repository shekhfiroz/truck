package com.truck.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.truck.main.dto.SignupDTO;
import com.truck.main.dto.VerifyOtpDTO;
import com.truck.main.enums.OtpTypeEnum;
import com.truck.main.service.SignupService;

@RestController
public class SignupController {

	@Autowired
	private SignupService signupService;

	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody SignupDTO signupDTO) {
		return signupService.signup(signupDTO);
	}

	@PostMapping("/verify-otp")
	public ResponseEntity<String> verifyOTP(@RequestBody VerifyOtpDTO verifyOtpDTO) {
		return signupService.verifyOTP(verifyOtpDTO, OtpTypeEnum.SIGNUP.name());
	}
}
