package com.dove.Dove_user_backend.entity.post;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_post")
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "club_name", nullable = false, length = 45)
    private String clubName;

    @Column(nullable = false, length = 60)
    private String title;

    @Column(length = 45)
    private String writer;

    private String description;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate eventDate;

    private String link;

}
