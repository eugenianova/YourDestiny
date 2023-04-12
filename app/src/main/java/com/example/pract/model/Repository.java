package com.example.pract.model;

import android.content.Context;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    private final DataSource<T> arrayDataSource;

    public Repository(DataSource<T> arrayDataSource, Context context_storage) {
        this.arrayDataSource = arrayDataSource;
    }

    public List<T> getAll() {
        List<T> result = new ArrayList<>();
        result.addAll(arrayDataSource.getAll());
        return result;
    }

    public void add(T item) {
        arrayDataSource.add(item);

    }

}
