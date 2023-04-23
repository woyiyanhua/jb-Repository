package com.jb.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jb.pojo.Logininfo;
import com.jb.website.WebSiteApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = WebSiteApplication.class)
@Slf4j
public class LoginInfoTest {
    @Autowired
    private LoginInfoMapper lm;

    @Test
    void findById(){
        Logininfo li = lm.selectById(4);
        log.info("login:"+li);
    }

    @Test
    void findByPage(){
        Page<Logininfo> page = new Page<>(1,2);
        lm.selectPage(page,null);
        log.info("总记录数:"+page.getTotal());
        log.info("当前页码:"+page.getCurrent());
        log.info("页容量:"+page.getSize());
        log.info("总页数:"+page.getPages());
        log.info("当前页记录:"+page.getRecords());
    }
}
