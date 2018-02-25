package com.example.c4q.dogapp.model;

import java.util.List;

/**
 * Created by c4q on 2/25/18.
 */

public class DogImage {
     private String status;
     private List<String> message;

    public DogImage(String status, List<String> message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public List<String> getMessage() {
        return message;
    }
}
