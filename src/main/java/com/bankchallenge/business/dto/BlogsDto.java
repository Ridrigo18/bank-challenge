package com.bankchallenge.business.dto;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BlogsDto {
    private Long id;
    private String title;
    private String description;

}
