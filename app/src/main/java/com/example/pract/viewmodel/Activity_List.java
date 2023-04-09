package com.example.pract.viewmodel;

public class Activity_List {
    int Image;
    String title;
    int id;
    public Activity_List(int id, int image, String title){
        Image = image;
        this.title = title;
        this.id = id;
    }

    public int getImage(){return Image;}

    public void setImage(int image){Image = image;}

    public String getTitle(){return title;}

    public void setTitle(String title){this.title = title;}

    public void setId(int id){this.id = id;}

    public int getId(){return id;}
}
