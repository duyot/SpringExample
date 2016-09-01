package com.vivas.springmvc.config;

import com.vivas.springmvc.base.exception.CommonException;
import com.vivas.springmvc.base.exception.RequestNotFoundException;
import com.vivas.springmvc.utils.Constants;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by duyot on 9/1/2016.
 */
@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(CommonException.class)
    public String ErrorHandler(){
        return Constants.VIEW.ERROR;
    }

    @ExceptionHandler(RequestNotFoundException.class)
    public String RequestNotFoundHandler(){
        return Constants.VIEW.ERROR;
    }


}
