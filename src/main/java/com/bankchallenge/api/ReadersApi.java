package com.bankchallenge.api;


import com.bankchallenge.business.dto.ReadersDto;
import com.bankchallenge.business.service.ReadersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/challenge/rest")
public class ReadersApi {

    @Autowired
    private ReadersService readersService;

    @GetMapping("/readers")
    public List<ReadersDto> getReaders() {
        return readersService.getAll();
    }
}
