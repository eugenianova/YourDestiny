package com.example.pract.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Search {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "search_history")
    public String search;

    public Search(String search) {
        this.search = search;
    }
}