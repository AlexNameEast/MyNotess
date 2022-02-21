package com.example.mynotess.domain;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.material.datepicker.MaterialDatePicker;

public class Note implements Parcelable {

    private final String id;

    private String title;

    private String description;

    private MaterialDatePicker materialDatePicker;

    private int img;

    public Note(String id, String title, String description, int img) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.materialDatePicker = MaterialDatePicker
                .Builder
                .datePicker()
                .setTitleText("Select date")
                .build();
        this.img = img;
    }

    protected Note(Parcel in) {
        id = in.readString();
        title = in.readString();
        description = in.readString();
        img = in.readInt();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImg() {
        return img;
    }

    public MaterialDatePicker getMaterialDatePicker() {
        return materialDatePicker;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeInt(img);
    }
}
