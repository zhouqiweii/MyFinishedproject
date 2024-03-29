package com.zhouqiwei.demo.mapper;


import com.zhouqiwei.demo.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
@Repository
public interface UserMapper {
    @Insert("INSERT INTO user(name,password) VALUES(#{name},#{password})")
    int saveUser(@Param("name") String name, @Param("password") String password);
    @Select("select id,name,password from user where name=#{name}")
    User selectUser(@Param("name") String name);
}
