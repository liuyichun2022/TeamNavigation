package com.dash.navigation.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常拦截
 * @author Jason.liu
 * @date 204-02-04
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 其他未被捕获的异常.
     *
     * @param throwable 所有的未被捕获或定义的异常
     * @return String
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public String exception(Throwable throwable) {
        log.error(throwable.getMessage(), throwable);
        return throwable.getMessage();
    }
}
