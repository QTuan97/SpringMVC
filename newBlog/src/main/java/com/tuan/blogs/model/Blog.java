package com.tuan.blogs.model;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String author_name;
    private String title;
    private String content;

    public Blog(){

    }

    public Blog(String author_name, String title, String content) {
        this.author_name = author_name;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString(){
        return String.format("Blog[id=%d, author_name='%s', title='%s', content='%s']", id,author_name,title,content);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
