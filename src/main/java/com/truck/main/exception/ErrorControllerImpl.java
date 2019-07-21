package com.truck.main.exception;

import javax.servlet.http.HttpServletRequest;
//import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorControllerImpl implements ErrorController {

	@RequestMapping("/error")
	public void handleError(HttpServletRequest request) throws Throwable {
		if (request.getAttribute("javax.servlet.error.exception") != null) {
			throw (Throwable) request.getAttribute("javax.servlet.error.exception");
		}
	}

	@Override
	public String getErrorPath() {
		return null;
	}

}
