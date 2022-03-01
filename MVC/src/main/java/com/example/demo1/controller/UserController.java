package com.example.demo1.controller;

import com.example.demo1.service.UserBo;
import com.example.demo1.service.UserService;

/**
 * @auther xianyue
 * @date 2022/2/12 - 星期六 - 20:29
 **/
public class UserController {
    private UserService userService;

    public UserVo getUserById(Long id) {
        UserBo userBo = userService.getUserById(id);
        return null;
    }
}
