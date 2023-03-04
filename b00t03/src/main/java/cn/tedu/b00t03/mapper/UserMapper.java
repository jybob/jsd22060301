package cn.tedu.b00t03.mapper;

import cn.tedu.b00t03.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("insert into user values(null,#{username},#{password},#{nick})")
    void insert(User user);


    @Select("select password from user where username=#{username}")
    User selectByUsername(String username);
}
