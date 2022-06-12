package com.evan.wj.exception;

import com.evan.wj.result.Result;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 北落燕门
 */
@RestControllerAdvice
public class GlobalException {

    /**
     * 捕获请求方式异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return new Result(401, "请求方式错误", null);
    }

    /**
     * 捕获请求体缺失
     *
     * @param e
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result httpMessageNotReadableException(HttpMessageNotReadableException e) {
        return new Result(402, "请求体缺失", null);
    }

}
