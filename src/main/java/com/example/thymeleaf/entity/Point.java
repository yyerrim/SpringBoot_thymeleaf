package com.example.thymeleaf.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Point {
    @Id
    Integer id;
    String title;
    Double lat;
    Double lng;

    @Override
    public String toString() {
        return "{lat:" + lat + ", lng:" + lng + "}";
        // return "{\"lat\":" + lat + ", \"lng\":" + lng + "}";
    }
}
