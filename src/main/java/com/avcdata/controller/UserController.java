package com.avcdata.controller;

import com.avcdata.model.PageInfoParam;
import com.avcdata.model.User;
import com.avcdata.service.UserService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by huangcheng on 2017/3/24.
 */
@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public PageInfo<User> query(@RequestBody PageInfoParam pageInfoParam){
        log.info("currentPage:{}, pageSize:{}", pageInfoParam.getCurrentPage(), pageInfoParam.getPageSize());
        return new PageInfo<>(userService.query(pageInfoParam));
    }
}
