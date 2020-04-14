package com.example.surveycovid_19;

import android.os.Parcel;
import android.os.Parcelable;

public class Question {
    private int id;
    private String name;
    public Question(){}
    public Question(String name,String age,String result){
        this.name = name;
        this.age = age;
        this.result = result;
    }
    public Question(int id,String name,String age,String result){
        this.id = id;
        this.name = name;
        this.age = age;
        this.result = result;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    private String age;
    private String result;

}
