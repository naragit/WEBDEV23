package dev.web.restcall;

import java.util.Map;

public class Product {
    private String id;
    private String name;
    private Map<String, Object> data; // dynamic attributes

    // Getters and setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getData() {
        return data;
    }
    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
