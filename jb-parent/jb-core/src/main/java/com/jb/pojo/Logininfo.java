package com.jb.pojo;


import lombok.Data;

@Data
public class Logininfo extends BaseDomain{
    public static final int STATE_NORMAL = 0 ;
    public static final int USER_MANAGER = 0 ;//后台用户
    public static final int USER_CLIENT = 1 ;// 前台用户
    private String username;
    private String password;
    private Integer state;
    private Integer userType;
}
