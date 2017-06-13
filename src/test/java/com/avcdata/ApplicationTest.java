package com.avcdata;

import com.avcdata.dao.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by huangcheng on 2017/4/30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void testGetName(){
        Assert.assertEquals(1,userMapper.selectAll().size());
    }

}
