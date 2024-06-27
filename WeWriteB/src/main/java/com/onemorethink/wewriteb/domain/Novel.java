package com.onemorethink.wewriteb.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "createdAt")
})
@Entity
public class Novel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* @ManyToOne
     * JoinColum 외래키로 사용될 열 이름을 지정
     * @JoinColumn(name = "author_id", nullable = false)
     * private User author;
     * 로그인 기능이 붙었을 때 해당 필드 활성화
     */

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String createdAt;

    @Column(nullable = true)
    private String updatedAt;


}