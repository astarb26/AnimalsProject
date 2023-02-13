package com.example.hitprojectanimals;

import android.widget.EditText;

public class DataModel {
    String name;
    String version;
    int id_;
    int image;

    public DataModel(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public DataModel(String name, String version , int id_, int image) {
        this.name = name;
        this.version = version;
        this.id_ = id_;
        this.image = image;
    }

    public DataModel(EditText edtTitle) {
    }


    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public int getImage() {
        return image;
    }

    public int getId() {
        return id_;
    }
}

