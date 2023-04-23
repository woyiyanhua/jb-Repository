package com.jb.website.service;

public interface LogininfoService {
    /**
     * 注册
     * @param username
     * @param password
     */
    void register(String username ,String password);
    /**
     * 检查用户名是否存在
     * @param username
     * @return
     */
    boolean checkUserNameExist(String username);

    void login(String username, String password);
}
