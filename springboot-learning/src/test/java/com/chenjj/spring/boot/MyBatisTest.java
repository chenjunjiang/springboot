package com.chenjj.spring.boot;

import com.chenjj.spring.boot.dao.User1Dao;
import com.chenjj.spring.boot.dao.UserDao;
import com.chenjj.spring.boot.model.User;
import com.chenjj.spring.boot.model.User1;
/*import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by chenjunjiang on 18-10-4.
 */
//@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisTest {
    private static final Logger log = LoggerFactory.getLogger(MyBatisTest.class);

    @Autowired
    private UserDao userDao;
    @Autowired
    private User1Dao user1Dao;

    //@Test
    public void test() {
        /*final int row1 = userDao.insert(new User("u1", "p1"));
        log.info("[添加结果] - [{}]", row1);
        final int row2 = userDao.insert(new User("u2", "p2"));
        log.info("[添加结果] - [{}]", row2);
        final int row3 = userDao.insert(new User("u3", "p3"));
        log.info("[添加结果] - [{}]", row3);*/
        List<User> u1 = userDao.findByUsername("u1");
        log.info("[根据用户名查询] - [{}]", u1);
    }

    //@Test
    public void test1() {
        /*final User1 user1 = new User1("u1", "p1");
        final User1 user2 = new User1("u2", "p2");
        final User1 user3 = new User1("u3", "p3");
        user1Dao.insertSelective(user1);
        log.info("[user1回写主键] - [{}]", user1.getId());
        user1Dao.insertSelective(user2);
        log.info("[user2回写主键] - [{}]", user2.getId());
        user1Dao.insertSelective(user3);
        log.info("[user3回写主键] - [{}]", user3.getId());
        final int count = user1Dao.countByUsername("u1");
        log.info("[调用自己写的SQL] - [{}]", count);

        // 模拟分页
        user1Dao.insertSelective(new User1("u4", "p4"));
        user1Dao.insertSelective(new User1("u5", "p5"));
        user1Dao.insertSelective(new User1("u6", "p6"));
        user1Dao.insertSelective(new User1("u7", "p7"));
        user1Dao.insertSelective(new User1("u8", "p8"));
        user1Dao.insertSelective(new User1("u9", "p9"));
        user1Dao.insertSelective(new User1("u10", "p10"));
        user1Dao.insertSelective(new User1("u11", "p11"));
        user1Dao.insertSelective(new User1("u12", "p12"));
        user1Dao.insertSelective(new User1("u13", "p13"));
        user1Dao.insertSelective(new User1("u14", "p14"));
        user1Dao.insertSelective(new User1("u15", "p15"));
        user1Dao.insertSelective(new User1("u16", "p16"));
        user1Dao.insertSelective(new User1("u17", "p17"));
        user1Dao.insertSelective(new User1("u18", "p18"));*/
        // TODO 分页 + 排序 this.userMapper.selectAll() 这一句就是我们需要写的查询，有了这两款插件无缝切换各种数据库
        /*final PageInfo<User1> pageInfo = PageHelper.startPage(2, 10).setOrderBy("id desc")
                .doSelectPageInfo(() -> this.user1Dao.selectAll());
        List<User1> user1s = pageInfo.getList();
        log.info("[lambda写法] - [分页信息] - [{}]", pageInfo.toString());*/
    }
}
