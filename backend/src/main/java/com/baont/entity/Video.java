package com.baont.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "videos")
@Data
public class Video {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String caption;
    private String videoUrl;
    private String thumbnail;
    private Integer viewCount = 0;
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "video", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Comment> comments;
}
