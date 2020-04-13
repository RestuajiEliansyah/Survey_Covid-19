package com.example.surveycovid_19;

import android.os.Parcel;
import android.os.Parcelable;

public class Question implements Parcelable {
    private int id;
    private String name;
    private String age;

    protected Question(Parcel in) {
        id = in.readInt();
        name = in.readString();
        age = in.readString();
        result = in.readString();
    }
public Question(){}

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

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

    private String result;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(age);
        dest.writeString(result);
    }
}
