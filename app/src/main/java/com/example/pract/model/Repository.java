package com.example.pract.model;

import android.content.Context;

import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    private final DataSource<T> arrayDataSource;

    public AppDatabase db = null;
    public UserDao userDao = null;
    public List<Search> history = null;

    public Repository(DataSource<T> arrayDataSource, Context context) {
        this.arrayDataSource = arrayDataSource;
        db = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, "History_Search").allowMainThreadQueries().build();
        userDao = db.userDao();
        history = db.userDao().getAll();
    }

    public List<T> getAll() {
        List<T> result = new ArrayList<>();
        result.addAll(arrayDataSource.getAll());
        return result;
    }

    public void add(T item) {
        arrayDataSource.add(item);
    }

    public void insert(String search) {
        userDao.insertAll(new Search(search));
    }
    public void getHistory(){
        for(Search list: history)
            System.out.println(list.search);
   }

}
