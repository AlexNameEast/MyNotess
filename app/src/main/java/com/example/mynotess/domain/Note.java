package com.example.mynotess.domain;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;

import com.google.android.material.datepicker.MaterialDatePicker;

public class Note implements Parcelable {

    private final String id;

    @DrawableRes
    private int image;

    private String title;

    private String description;

    private MaterialDatePicker materialDatePicker;

    public Note(String id, int image, String title, String description) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.description = description;
        this.materialDatePicker = MaterialDatePicker
                .Builder
                .datePicker()
                .setTitleText("Select date")
                .build();
    }

    protected Note(Parcel in) {
        id = in.readString();
        image = in.readInt();
        title = in.readString();
        description = in.readString();

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

    public MaterialDatePicker getMaterialDatePicker() {
        return materialDatePicker;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public int getImage() {
        return image;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeInt(image);
        parcel.writeString(title);
        parcel.writeString(description);
    }
}
