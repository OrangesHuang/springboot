package com.avcdata.service;

import com.avcdata.dao.UserMapper;
import com.avcdata.model.PageInfoParam;
import com.avcdata.model.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huangcheng on 2017/3/24.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> query(PageInfoParam pageInfoParam){
        PageHelper.startPage(pageInfoParam.getPageSize(), pageInfoParam.getCurrentPage());
        return userMapper.selectAll();
    }
}
