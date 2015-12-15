package com.xuanniu.bms.dao.mapper;

import com.xuanniu.bms.dao.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Delete({
        "delete from sys_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into sys_user (id, username, ",
        "password, salt, ",
        "status, real_name, ",
        "remark, email, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=BIGINT}, #{username,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{salt,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=TINYINT}, #{realName,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(User record);

    int insertSelective(User record);

    @Select({
        "select",
        "id, username, password, salt, status, real_name, remark, email, create_time, ",
        "update_time",
        "from sys_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("BaseResultMap")
    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    @Update({
        "update sys_user",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "salt = #{salt,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "real_name = #{realName,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(User record);

    @Select({
            "select",
            "id, username, password, status, create_time, update_time",
            "from sys_user"
    })
    @ResultMap("BaseResultMap")
    List<User> getUserList();

    @Select({
            "select",
            "id, username, password, status, create_time, update_time",
            "from sys_user",
            "where username = #{username,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    User findByUserName(String username);
}