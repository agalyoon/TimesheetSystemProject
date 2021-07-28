package com.training.disasterproject.exception;

public class RecordExistsException extends Exception
{

	private static final long serialVersionUID = 1L;

	public RecordExistsException()
	{
		super();
	}

	public RecordExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RecordExistsException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public RecordExistsException(String message)
	{
		super(message);
	}

	public RecordExistsException(Throwable cause)
	{
		super(cause);
	}

}
