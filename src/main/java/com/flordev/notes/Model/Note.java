package com.flordev.notes.Model;

import javax.persistence.*;
import java.util.Date;
import com.flordev.notes.Model.User;



@Entity
public class Note {

    private  String title;
    private  String content;
    private  Date date;
    @OneToOne
    private  User user;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    public Note(String title,String content, Date date, User user) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.user = user;
    }
    public Note(){}



    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }
    public String getTitle() {
        return title;
    }

}
