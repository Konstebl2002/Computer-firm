package com.example.Computerfirm.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.yaml.snakeyaml.events.Event;

@Data
@AllArgsConstructor
public class Product {
    private Long ID;
    private String title;
    private String description;
    private int price;
    private String city;
    private String author;



    public void setId(long ID) {
        this.ID= ID;
    }

    public long getId() {
        return ID;
    }
}
