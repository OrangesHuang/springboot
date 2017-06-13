package com.avcdata.dao;

import com.avcdata.model.User;
import com.avcdata.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * Created by huangcheng on 2017/3/24.
 */
//继承了通用MyMapper，则可以根据Bean实现简单的增删改查
@Mapper
public interface UserMapper extends MyMapper<User> {
    List<User> query(String s);
}
