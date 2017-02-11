package com.example.mohits1005.myapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static android.R.attr.id;

/**
 * Created by mohits1005 on 2/8/2017.
 */

public class Student {
    List<String> id;
    Map<String,NameData> name;

    public Map<String, NameData> getName() {
        return name;
    }

    public void setName(Map<String, NameData> name) {
        this.name = name;
    }

    String status = "";

    public List<String> getId() {
        return id;
    }

    public void setId(List<String> id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
