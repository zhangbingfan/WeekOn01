package com.bw.weekone01.bean;

import java.util.ArrayList;

public class Json {
    private String message;
    private String status;
    private ArrayList<Data> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Data> getResult() {
        return result;
    }

    public void setResult(ArrayList<Data> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Json{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", result=" + result +
                '}';
    }
}
