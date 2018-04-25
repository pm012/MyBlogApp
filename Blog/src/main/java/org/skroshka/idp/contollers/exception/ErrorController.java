package org.skroshka.idp.contollers.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Serhii Kroshka on 25-April-18
 *
 */

// What is controller advice? What does it do?
@ControllerAdvice
public class ErrorController {

	private static Logger logger = LoggerFactory.getLogger(ErrorController.class);

	//
	@ExceptionHandler(Throwable.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView exception(final Throwable throwable, final Model model) {
		logger.error("Exception during execution of the application", throwable);// throwable??

		ModelAndView modelAndView = new ModelAndView("error");

		// get error message from exception
		String errorMessage = (throwable != null ? throwable.toString() : "Unknown error");
		// pass error message the model
		modelAndView.addObject("errorMessage", errorMessage);

		return modelAndView;

	}

}
