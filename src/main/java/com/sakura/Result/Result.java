package com.sakura.Result;

public class Result {
    private int code;
    private String type;
    private String message;
    private Object data;
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Result(int code, String type,boolean success, String message) {
        this.code = code;
        this.type = type;
        this.success = success;
        this.message = message;
    }

    public Result(int code, String type,boolean success, String message, Object data) {
        this.code = code;
        this.type = type;
        this.message = message;
        this.data = data;
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
