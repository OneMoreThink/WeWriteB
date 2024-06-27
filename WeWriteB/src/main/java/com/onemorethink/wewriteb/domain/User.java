package com.onemorethink.wewriteb.domain;

import com.onemorethink.wewriteb.config.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "email"),
        @Index(columnList = "nickname"),
        @Index(columnList = "createdAt")
})
@Entity
public class User extends BaseTimeEntity {

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

}
