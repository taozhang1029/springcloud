package com.kingsley.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Time : 2020/12/3 21:25
 * @Author : Kingsley
 * @Project : Leyou
 * @File : User.java
 * @IDE : IntelliJ IDEA
 */
@Data
@Table(name = "ly_user")
public class User implements Serializable {

    @Id
    private Long id;
    
    /**
     * 用户名
     */
    private String username;

    private String password;
    
    /**
     * 姓名
     */
    private String name;

    private Integer age;
    
    /**
     * 性别：1：男，2：女
     */
    private Integer sex;
    
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    
    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    
    /**
     * 更新时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    
    /**
     * 备注
     */
    private String remark;

}
