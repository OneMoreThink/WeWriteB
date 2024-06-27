package com.onemorethink.wewriteb.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;
import java.time.LocalDateTime;


@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "email"),
        @Index(columnList = "nickname"),
        @Index(columnList = "createdAt")
})
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String nickname;

//    @OneToMany(mappedBy = "author")
//    private List<Novel> novels;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = true)
    private LocalDateTime updateAt;
}
