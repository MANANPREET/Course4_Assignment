package com.upgrad.ImageHoster.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Comment")
public class Comment implements Serializable{
    // These annotations auto-increments the id column for us whenever
    // a new Image object is stored into the database
    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String text;

    @Column
    private LocalDate commentDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private Image image;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Comment() { }

    public Comment(String text, User user, Image image) {
        this.text = text;
        this.user = user;
        this.image = image;
        this.commentDate = LocalDate.now();
    }

    public int getId() {
        return this.id;
    }

    public String getText() { return this.text; }

    public void setText(String text) {
        this.text = text;
    }

    public String getCommentDate() {
        return commentDate.toString();
    }

    public void setCommentDate(LocalDate commentDate) {
        this.commentDate = commentDate;
    }

    public void setImage(Image image) { this.image = image; }

    public Image getImage() { return this.image; }

    public void setUser(User user) { this.user = user; }

    public User getUser() { return this.user; }


}
