package com.example.pract.model;

import java.util.List;

public interface DataSource<T> {
    List<T> getAll();
    void add(T item);
}