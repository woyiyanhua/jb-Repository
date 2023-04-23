package com.jb.website.controller;


import com.jb.util.JSONResult;
import com.jb.website.service.LogininfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogininfoController {
    @Autowired
    private LogininfoService logininfoService;
    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/register")
    public JSONResult register(String username, String
            password) {
        JSONResult json = new JSONResult();
        try {
            this.logininfoService.register(username,
                    password);
        } catch (RuntimeException e) {
            e.printStackTrace();
            json.setSuccess(false);
            json.setMsg(e.getMessage());
        }
        return json;
    }

    @PostMapping("/login")
    public JSONResult login(String username, String password){
            JSONResult json = new JSONResult();
            try {
                this.logininfoService.login(username,
                        password);
            } catch (RuntimeException e) {
                e.printStackTrace();
                json.setSuccess(false);
                json.setMsg(e.getMessage());
            }
            return json;
    }

    /**
     * 检查用户名是否存在
     *
     * @param username
     * @return
     */
    @PostMapping("/checkUserName")
    public boolean checkUserName(String username) {
        return
                !this.logininfoService.checkUserNameExist(username);
    }
}
