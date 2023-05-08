package com.ssafy.faraway.domain.post.entity;

import com.ssafy.faraway.common.entity.BaseEntity;
import com.ssafy.faraway.domain.member.entity.Member;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class Post extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "category", nullable = false, length = 20)
    private String category;
    @Column(name = "title", nullable = false, length = 30)
    private String title;
    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;
    @Column(name = "hit", nullable = false)
    @ColumnDefault("0")
    private Long hit;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Post(String category, String title, String content, Member member) {
        this.category = category;
        this.title = title;
        this.content = content;
        this.member = member;
    }

    public void update(String title, String content, String category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public void updateHit(Long hit) {
        this.hit++;
    }
}
