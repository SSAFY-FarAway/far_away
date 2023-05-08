package com.ssafy.faraway.domain.member.entity;

import com.ssafy.faraway.common.entity.BaseEntity;
import com.ssafy.faraway.domain.post.entity.Post;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class Member extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name= "login_id", nullable = false, unique = true, length = 20)
    private String loginId;
    @Column(name = "long_pwd", nullable = false)
    private String loginPwd;
    @Column(name="last_name", nullable = false, length = 20)
    private String lastName;
    @Column(name="first_name", nullable = false, length = 30)
    private String firstName;
    @Column(name="birth", nullable = false, length = 6)
    private String birth;
    @Column(name="email", nullable = false, length = 100, unique = true)
    private String email;
    @Column(name = "zipcode", nullable = false, length = 5)
    private String zipcode;
    @Column(name = "main_address", nullable = false)
    private String mainAddress;
    @Column(name ="sub_address", nullable = false)
    private String subAddress;
    @Column(name="salt", nullable = false, length = 45)
    private String salt;
    @Column(name="mileage", nullable = false)
    @ColumnDefault("0")
    private Long mileage;
    @Column(name="role", nullable = false)
    @ColumnDefault("1")
    private int role;
    @Column(name="certified", nullable = false)
    @ColumnDefault("0")
    private int certified;

    @OneToMany(mappedBy = "post")
    private List<Post> posts = new ArrayList<>();

    @Builder
    public Member(String loginId, String loginPwd, String lastName, String firstName, String birth, String email, String zipcode, String mainAddress, String subAddress, String salt) {
        this.loginId = loginId;
        this.loginPwd = loginPwd;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birth = birth;
        this.email = email;
        this.zipcode = zipcode;
        this.mainAddress = mainAddress;
        this.subAddress = subAddress;
        this.salt = salt;
    }
}


