package com.training.disasterproject.exception;

public class RecordNotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;

	public RecordNotFoundException()
	{
	}

	public RecordNotFoundException(String message)
	{
		super(message);
	}

	public RecordNotFoundException(Throwable cause)
	{
		super(cause);
	}

	public RecordNotFoundException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public RecordNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
