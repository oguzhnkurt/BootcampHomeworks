package com.example.OguzhanKurt.PatikaHomework2.general;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseEntity {
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}