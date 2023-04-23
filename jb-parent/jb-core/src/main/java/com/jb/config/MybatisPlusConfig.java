package com.jb.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class MybatisPlusConfig {
        /**
         * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置
         MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现
         问题
         *
         * mp 与 pagehelper 存在依赖 jsqlparser 冲突，不建议混用
         */
        @Bean
        public MybatisPlusInterceptor mybatisPlusInterceptor() {
            MybatisPlusInterceptor interceptor = new
                    MybatisPlusInterceptor();
            interceptor.addInnerInterceptor(new
                    PaginationInnerInterceptor(DbType.MYSQL));
            return interceptor;
        }
    }
