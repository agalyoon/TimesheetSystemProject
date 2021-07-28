package com.training.disasterproject.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorController
{

	private static Logger logger = LoggerFactory.getLogger(ErrorController.class);

	@ExceptionHandler(Throwable.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String exception(final Throwable throwable, final Model model)
	{
		logger.error("Exception during execution of SpringSecurity application", throwable);
		String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
		model.addAttribute("errorMessage", errorMessage);
		return "error";
	}

	@ExceptionHandler(RecordNotFoundException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String exception(final RecordNotFoundException ex, final Model model)
	{
		logger.error("Exception during execution of SpringSecurity application", ex);
		String errorMessage = (ex != null ? ex.getMessage() : "Unknown error");
		model.addAttribute("errorMessage", errorMessage);
		return "error";
	}

	@ExceptionHandler(RecordExistsException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String exception(final RecordExistsException ex, final Model model)
	{
		logger.error("Exception during execution of SpringSecurity application", ex);
		String errorMessage = (ex != null ? ex.getMessage() : "Unknown error");
		model.addAttribute("errorMessage", errorMessage);
		return "error";
	}
}