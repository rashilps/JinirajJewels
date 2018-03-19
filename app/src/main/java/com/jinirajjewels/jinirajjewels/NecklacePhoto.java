package com.jinirajjewels.jinirajjewels;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rashil on 11/3/18.
 */

public class NecklacePhoto implements Parcelable {
    private String mUrl;
    private String mTitle;

    public NecklacePhoto(String url, String title) {
        mUrl = url;
        mTitle = title;
    }

    protected NecklacePhoto(Parcel in) {
        mUrl = in.readString();
        mTitle = in.readString();
    }

    public static final Creator<NecklacePhoto> CREATOR = new Creator<NecklacePhoto>() {
        @Override
        public NecklacePhoto createFromParcel(Parcel in) {
            return new NecklacePhoto(in);
        }

        @Override
        public NecklacePhoto[] newArray(int size) {
            return new NecklacePhoto[size];
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

    public static  NecklacePhoto[] getSpacePhotos() {

        return new NecklacePhoto[]{
                new NecklacePhoto("https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/necklace1.jpg?alt=media&token=cabe073a-826f-49b2-adaa-cc2916389fc7", "Space Shuttle"),
                new NecklacePhoto("https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/necklace2.jpg?alt=media&token=362e1ad8-a0db-4ca0-a752-7a237d2769d1", "Galaxy Orion"),
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
