package com.springboot.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/***
实体类
 */
@Entity
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String tel;
    private String addr;
    private String sex;
}
