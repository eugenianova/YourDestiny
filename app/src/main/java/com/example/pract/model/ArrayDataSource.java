package com.example.pract.model;

import java.util.ArrayList;
import java.util.List;

public class ArrayDataSource<T> implements DataSource<T> {
    private List<T> data = new ArrayList<>();

    @Override
    public List<T> getAll() {
        return data;
    }

    @Override
    public void add(T item) {
        data.add(item);
    }

}