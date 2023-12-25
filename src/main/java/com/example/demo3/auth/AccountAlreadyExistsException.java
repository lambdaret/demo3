package com.example.demo3.auth;

import org.springframework.security.core.AuthenticationException;

public class AccountAlreadyExistsException extends AuthenticationException {

	private static final long serialVersionUID = -8432665017283863776L;

	public AccountAlreadyExistsException(String msg, Throwable t) {
        super(msg, t);
    }

    public AccountAlreadyExistsException(String msg) {
        super(msg);
    }
}