package com.jinirajjewels.jinirajjewels;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rashil on 11/3/18.
 */

public class RingsPhoto implements Parcelable {
    private String mUrl;
    private String mTitle;

    public RingsPhoto(String url, String title) {
        mUrl = url;
        mTitle = title;
    }

    protected RingsPhoto(Parcel in) {
        mUrl = in.readString();
        mTitle = in.readString();
    }

    public static final Creator<RingsPhoto> CREATOR = new Creator<RingsPhoto>() {
        @Override
        public RingsPhoto createFromParcel(Parcel in) {
            return new RingsPhoto(in);
        }

        @Override
        public RingsPhoto[] newArray(int size) {
            return new RingsPhoto[size];
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

    public static  RingsPhoto[] getSpacePhotos() {

        return new RingsPhoto[]{
                new RingsPhoto("https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/ring1.jpg?alt=media&token=6e9f1c1d-c196-4c44-af13-411fa5fb5bdc", "Space Shuttle"),
                new RingsPhoto("https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/ring2.jpg?alt=media&token=cc916dec-a477-42e5-bf4a-56ce9798829b", "Galaxy Orion"),
                new RingsPhoto("https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/ring3.jpg?alt=media&token=5bb3b598-7506-4c1a-8344-95fd900d9e68", "Earth"),
                new RingsPhoto("https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/ring4.jpg?alt=media&token=0078c92f-4dc8-47da-a7f7-1e3585187bc5", "Astronaut"),
                new RingsPhoto("https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/ring5.jpg?alt=media&token=2b08b436-d739-41f8-b17f-aa02135d71fa", "Satellite"),
                new RingsPhoto("https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/ring6.jpg?alt=media&token=f72b482d-4764-40dd-91af-5f2546c53ce8", "Satellite"),
                new RingsPhoto("https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/ring7.jpg?alt=media&token=5d99e8ff-eaaf-4fba-b59e-cee2c20d222c", "Satellite"),
                new RingsPhoto("https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/ring8.jpg?alt=media&token=35f1433b-59ba-4150-bc2e-f8a7fa665a1b", "Satellite"),
                new RingsPhoto("https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/ring9.jpg?alt=media&token=c149dfd7-d41d-4231-8323-fff08983a72d", "Satellite"),
                new RingsPhoto("https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/ring10.jpg?alt=media&token=e4020574-ed09-4c88-834a-5e346abd4dcd", "Satellite"),
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
