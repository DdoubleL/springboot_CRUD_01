package com.springboot.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * 通用结果集
 * */
@Getter
@Setter
@ToString
public class Result {
    private Boolean flag;
    private Integer code;
    private String message;
    private Object data;
    /*
     * 有参构造：
     * @param flag是否成功 code返回码 message返回数据
     * 不一定所有返回都有数据，比如新增。
     * */
    public Result(Boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public Result() {
    }

    public Result(Boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
