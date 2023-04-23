package com.jb.website.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jb.mapper.LoginInfoMapper;
import com.jb.pojo.Logininfo;
import com.jb.util.MD5;
import com.jb.website.service.LogininfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LogininfoServiceImpl implements LogininfoService {
    @Autowired
    private LoginInfoMapper logininfoMapper;
    @Override
    public void register(String username, String password) {
//判断用户名字是否存在
        if ( !this.checkUserNameExist(username)) {
//用户名不存在的情况下保存用户
            Logininfo li = new Logininfo();
            li.setUsername(username);
//对密码进行md5加密
            li.setPassword(MD5.encode(password));
//开发中,避免使用魔法数字
            li.setState(Logininfo.STATE_NORMAL);
            li.setUserType(Logininfo.USER_CLIENT);
            this.logininfoMapper.insert(li);
//todo 初始化账户信息和Userinfo
        }else{
//存在的话直接抛异常
            throw new RuntimeException("该用户名已经存在!");
        }
    }
    @Override
    public boolean checkUserNameExist(String username) {
        LambdaQueryWrapper<Logininfo> queryWrapper = new
                LambdaQueryWrapper<>();
        queryWrapper.eq(Logininfo::getUsername,username);
        return logininfoMapper.selectCount(queryWrapper) > 0;
//表示存在该用户名
    }

    @Override
    public void login(String username, String password) {
        LambdaQueryWrapper<Logininfo> queryWrapper = new
                LambdaQueryWrapper<>();
        queryWrapper.eq(Logininfo::getUsername,username);
        if(!this.checkUserNameExist(username)){
            throw new RuntimeException("该用户名不存在");
        }
        Logininfo user = logininfoMapper.selectOne(queryWrapper);
        log.info("user:"+user);
        String EncodeMD5Pwd = MD5.encode(password);
        if(!EncodeMD5Pwd.equals(user.getPassword())){
            throw new RuntimeException("用户名或密码错误");
        }
    }
}
