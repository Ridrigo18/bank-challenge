package com.bankchallenge.business.dto;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class BlogsReadersDto {

    private Long id;
    private ReadersDto reader;
    private BlogsDto blog;


}
