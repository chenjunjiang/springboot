package com.chenjj.spring.boot.dao;

import com.chenjj.spring.boot.model.User1;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * Created by chenjunjiang on 18-10-4.
 */
@Mapper
public interface User1Dao extends BaseMapper<User1> {
    /**
     * 根据用户名统计（TODO 假设它是一个很复杂的SQL）
     *
     * @param username 用户名
     * @return 统计结果
     */
    int countByUsername(String username);
}
