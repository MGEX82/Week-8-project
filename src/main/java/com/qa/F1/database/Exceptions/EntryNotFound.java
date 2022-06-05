package com.qa.F1.database.Exceptions;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class EntryNotFound extends NoSuchElementException {
	public EntryNotFound() {
		super();
	}
	
	
}
