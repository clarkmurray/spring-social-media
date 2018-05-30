package com.clarkmurray;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Entity @Getter @Setter
@JsonPropertyOrder({"id", "firstName", "lastName", "createdAt", "updatedAt"})
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;


    private String firstName;
    private String lastName;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    public User() { }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
