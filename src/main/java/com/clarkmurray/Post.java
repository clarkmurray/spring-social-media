package com.clarkmurray;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity @Getter
@Setter
@JsonPropertyOrder({ "id", "content", "createdAt", "updatedAt"})
public class Post {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    public Post() { }


}
