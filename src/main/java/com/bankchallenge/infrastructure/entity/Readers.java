package com.bankchallenge.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "READERS")

public class Readers {
    @Id
    @Column
    @GeneratedValue
    private Long id;

    @Column(name = "NAME")
    public String name;


}
