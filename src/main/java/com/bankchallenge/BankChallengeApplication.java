package com.bankchallenge;

import com.bankchallenge.business.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankChallengeApplication implements CommandLineRunner {

    @Autowired
    private LoginUserService loginUserService;

    @Override
    public void run(final String... args) {
      /*final LoginUserDto loginUserDto = new LoginUserDto();
      loginUserDto.setEmail("financiera.group.service@gmail.com");
      loginUserDto.setPassword(ValidatorEncrypt.hashPassword("admin"));
      loginUserService.save(loginUserDto);*/
    }

    public static void main(String[] args) {
        SpringApplication.run(BankChallengeApplication.class, args);
    }

}
