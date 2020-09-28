package com.example.demo.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Greeting implements Serializable {
    private final long id;
    private final String content;

    @Override
    public String toString() {
        return "Greeting{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
