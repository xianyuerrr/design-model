package com.example.demo1.service;

import com.example.demo1.repository.UserEntity;
import com.example.demo1.repository.UserRepository;

/**
 * @auther xianyue
 * @date 2022/2/12 - 星期六 - 20:41
 **/
public class UserService {
    private UserRepository userRepository;
    public UserBo getUserById(Long id) {
        UserEntity userEntity = userRepository.getUserById(id);
        // UserBo userBo = [...convert userEntity to userBo...];
        return null;
    }
}
