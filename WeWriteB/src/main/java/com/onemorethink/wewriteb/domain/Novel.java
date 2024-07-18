package com.onemorethink.wewriteb.domain;


import com.onemorethink.wewriteb.config.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;
import java.util.List;
import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "createdAt")
})
@Entity
public class Novel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* @ManyToOne
     * JoinColum 외래키로 사용될 열 이름을 지정
     * @JoinColumn(name = "author_id",   nullable = false)
     * private User author;
     * 로그인 기능이 붙었을 때 해당 필드 활성화
     */

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "novel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Chapter> chapters;

    protected Novel() {}

    private Novel(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static Novel of(String title, String content){
        return new Novel(title, content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if  (!(o instanceof Novel novel)) return false;
        return id != null && Objects.equals(id, novel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
