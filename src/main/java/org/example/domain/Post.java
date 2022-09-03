package org.example.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String content;

    @ManyToOne
    private User author;

}
