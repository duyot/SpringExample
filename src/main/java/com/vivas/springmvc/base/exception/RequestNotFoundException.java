package com.vivas.springmvc.base.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by duyot on 9/1/2016.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND,
        reason="Request not found")
public class RequestNotFoundException extends RuntimeException {
}
