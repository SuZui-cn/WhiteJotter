package com.evan.wj.result;

import lombok.Data;

/**
 * @author 北落燕门
 */
@Data
public class Result {
    private int code;
    private String message;
    private Object result;

    public Result(int code, String message, Object result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public Result(int code) {
        this.code = code;
    }
}
