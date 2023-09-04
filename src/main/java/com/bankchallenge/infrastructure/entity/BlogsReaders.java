package com.bankchallenge.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BLOGS_READERS")

public class BlogsReaders {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "R_ID")
    private Readers reader;

    @ManyToOne
    @JoinColumn(name = "B_ID")
    private Blogs blog;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
