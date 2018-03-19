package com.jinirajjewels.jinirajjewels;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rashil on 11/3/18.
 */

public class MangalsutraPhoto implements Parcelable {
    private String mUrl;
    private String mTitle;

    public MangalsutraPhoto(String url, String title) {
        mUrl = url;
        mTitle = title;
    }

    protected MangalsutraPhoto(Parcel in) {
        mUrl = in.readString();
        mTitle = in.readString();
    }

    public static final Creator<MangalsutraPhoto> CREATOR = new Creator<MangalsutraPhoto>() {
        @Override
        public MangalsutraPhoto createFromParcel(Parcel in) {
            return new MangalsutraPhoto(in);
        }

        @Override
        public MangalsutraPhoto[] newArray(int size) {
            return new MangalsutraPhoto[size];
        }
    };

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public static  MangalsutraPhoto[] getSpacePhotos() {

        return new MangalsutraPhoto[]{
                new MangalsutraPhoto("https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/mangalsutra1.jpg?alt=media&token=2e8b4f94-1c4c-4f1c-841b-5d1ae32801e2", "Space Shuttle"),
                new MangalsutraPhoto("https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/mangalsutra2.jpg?alt=media&token=7db61ee1-ddfb-4fe1-a750-fa56fdddb1df", "Galaxy Orion"),
                };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mUrl);
        parcel.writeString(mTitle);
    }

}
