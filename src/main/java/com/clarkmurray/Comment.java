package com.clarkmurray;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String content;

    private Long userId;
    @ManyToOne
    @JoinColumn(name="userId", referencedColumnName= "id", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_comment_userid"))
    private User user;

    private Long postId;
    @ManyToOne
    @JoinColumn(name = "postId", referencedColumnName= "id", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_comment_postid"))
    private Post post;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    public Comment() { }
}
