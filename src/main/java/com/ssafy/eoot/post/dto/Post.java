package com.ssafy.eoot.post.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Post {
    // TODO: User DTO 생성 시 외래 키 필드 추가
    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    @NotBlank
    private PostLocation postLocation;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    private int hit;

    @NotBlank
    private Timestamp createdAt;

    @NotBlank
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "post")
    @NotNull
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    @NotNull
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    @Min(1)
    private List<Tag> tags = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    @NotNull
    private List<PostImage> images = new ArrayList<>();
}
