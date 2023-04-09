package com.example.pract.viewmodel;

public class Text_Changer {
    private String edited_text;


    public Text_Changer(String edited_text) {
        this.edited_text = edited_text;
    }

    public void Change_text(String text){
        edited_text = text;
    }

    public String getEdited_text(){
        return edited_text;
    }
}
