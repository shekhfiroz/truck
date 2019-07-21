package com.truck.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.truck.main.dto.LoginDTO;
import com.truck.main.model.Customer;
import com.truck.main.util.PasswordEncryptor;

@Service
public class LoginService {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private SignupService signupService;

	public ResponseEntity<String> login(LoginDTO loginDTO) {
		String hashedPassword = PasswordEncryptor.encryptPassword(loginDTO.getPassword());
		Query query = new Query();
		query.addCriteria(new Criteria().andOperator(Criteria.where("password").is(hashedPassword),
				new Criteria().orOperator(Criteria.where("mobile").is(loginDTO.getMobile()), Criteria.where("email").is(loginDTO.getEmail()))));

		Customer customer = mongoTemplate.findOne(query, Customer.class);
		if (customer == null) {
			return new ResponseEntity<>("Credential is not valid", HttpStatus.FORBIDDEN);
		} else {
			String token = signupService.createJwtUser(customer.getCustomerId());
			return new ResponseEntity<>(token, HttpStatus.OK);
		}
	}
}
