package com.springboot.dao;

import com.springboot.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public  interface UserDao {
    /**
     * @Auther:    on 2020/8/30 16:34
     * @param:   * @param user
     * @return: void
     * @Descpription: 新增用户
     */

    @Insert("insert into tb_user (id,name,tel,addr,sex) values(#{id},#{name},#{tel},#{addr},#{sex})")
    public void addUser(User user);

    @Update("update tb_user set name = #{name},tel = #{tel},addr = #{addr},sex = #{sex} where id = #{id}")
    void updateUser(User user);

    @Delete("delete from tb_user where id = #{id}")
    void deleteUser(int id);

    @Select("select * from tb_user where id = #{id}")
    User findById(int id);

    @Select("select * from tb_user")
    List<User> findAll();
}