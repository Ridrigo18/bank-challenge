package com.bankchallenge.business.service.impl;

import com.bankchallenge.business.dto.LoginUserDto;
import com.bankchallenge.business.mapper.LoginUserMapper;
import com.bankchallenge.business.service.LoginUserService;
import com.bankchallenge.infrastructure.entity.LoginUser;
import com.bankchallenge.infrastructure.repository.LoginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginUserServiceImpl implements LoginUserService {

    @Autowired
    private LoginUserRepository loginUserRepository;

    @Autowired
    private LoginUserMapper loginUserMapper;


    @Override
    public LoginUserDto getUserByEmail(String email) {
        final Optional<LoginUser> loginUser = loginUserRepository.getUserByEmail(email);
        return loginUser.map(user -> loginUserMapper.toDto(user)).orElse(null);
    }

    @Override
    public void save(final LoginUserDto loginUserDto) {
        final LoginUser loginUser = loginUserMapper.toEntity(loginUserDto);
        loginUserRepository.save(loginUser);

    }
}
