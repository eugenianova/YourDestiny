package com.example.pract.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Search.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
