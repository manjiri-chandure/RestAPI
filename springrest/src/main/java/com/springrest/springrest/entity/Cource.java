package com.springrest.springrest.entity;

public class Cource {

    private long id;
    private String title;
    private String description;

    public Cource(long id, String title, String description){
        super();
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Cource(){
        super();
    }

    public void setId(long id){
         this.id = id;
    }
    public long getId(){
        return id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setDescription(String description){
        this.description = description;
    }


    public String getDescription(){
        return description;
    }

    public String toString(){
        return "Course [id=" + id + ", title=" + title + ", description=" + description + "]";
    }

}
