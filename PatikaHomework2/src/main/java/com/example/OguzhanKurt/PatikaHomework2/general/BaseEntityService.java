package com.example.OguzhanKurt.PatikaHomework2.general;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BaseEntityService<T> {

    private List<T> items;
    public BaseEntityService(List<T> items) {
        this.items = items;
    }

    public void add(T item) {
        items.add(item);
    }

    public void remove(T item) {
        items.remove(item);
    }

    public void removeAt(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
    }

    public T get(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
    }

    public void clear() {
        items.clear();
    }

    public int size() {
        return items.size();
    }

    public List<T> getAll() {
        return new ArrayList<>(items);
    }
}