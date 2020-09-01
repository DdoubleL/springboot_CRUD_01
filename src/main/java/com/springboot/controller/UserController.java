package com.springboot.controller;

import com.springboot.entity.Result;
import com.springboot.entity.ResultCode;
import com.springboot.pojo.User;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    /*
     *查询所有
     * */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        List<User> list =userService.findAll();
        return new Result(true, ResultCode.SUCCESS,"查询成功",list);
    }
    /*
     *根据id查询
     * @param id
     * */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result findUserByName(@PathVariable int id){
        User user =userService.findUserById(id);
        return new Result(true, ResultCode.SUCCESS,"查询成功",user);
    }

    /*
     * 新增
     * @param user
     * */
    @RequestMapping(method = RequestMethod.POST)
    public Result addUser(@RequestBody User user){
        //性别进行判断，错误返回失败
//        if ((user.getSex() !="男") || (user.getSex() != "女")) {
//            return new Result(false,ResultCode.ERROR,"新增失败，性别错误");
//        }
//        userService.addUser(user);
//        return new Result(true,ResultCode.SUCCESS,"增加成功",user);

        if (user.getSex().equals("男")|| user.getSex().equals("女")) {
            userService.addUser(user);
            return new Result(true,ResultCode.SUCCESS,"增加成功",user);
        } else {
            return new Result(false,ResultCode.ERROR,"新增失败，性别错误");
        }
    }

    /*
     * 根据ID修改
     * @param user
     * */
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result updateById(@RequestBody User user) {
        //对ID进行判断，无数据返回错误
        if (user.getId() == null || user.getId().equals("")) {
            return new Result(false,ResultCode.ERROR,"修改失败，id不存在");
        }
        if ((user.getSex() !="男") || (user.getSex() != "女")) {
            return new Result(false,ResultCode.ERROR,"新增失败，性别错误");
        }
        userService.updateUser(user);
        return new Result(true,ResultCode.SUCCESS,"修改成功",user);
    }

    /*
     * 根据ID删除
     * @param id
     * */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable Integer id) {
        userService.deleteUser(id);
        return new Result(true,ResultCode.SUCCESS,"删除成功");
    }
}
