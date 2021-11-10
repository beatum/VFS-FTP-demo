package com.asteelflash.ext;

/**
 * @author happy.he
 * @version 1.0
 * @date 11/9/2021 3:54 PM
 */
public class Response {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    private String message;
    private Boolean result = true;
    private Object obj;
}
