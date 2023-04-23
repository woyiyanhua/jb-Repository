package com.jb.util;

import lombok.Data;

@Data
public class JSONResult {
    private boolean success = true ;
    private String msg;
    public JSONResult(boolean success, String msg) {
        super();
        this.success = success;
        this.msg = msg;
    }
    public JSONResult(String msg) {
        super();
        this.msg = msg;
    }
    public JSONResult() {
        super();
    }
}
