package com.example.pract.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM Search")
    List<Search> getAll();

    @Insert
    void insertAll(Search... users);
}