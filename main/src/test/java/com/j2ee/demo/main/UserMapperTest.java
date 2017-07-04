package com.j2ee.demo.main;

/**
 * Created by rihai on 7/4/2017.
 */

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationcontext.xml"})
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void getUsers() {
        List<User> list = userMapper.getUsers();
        Assert.isTrue(list.size() > 0);

    }
}
