package com.jinirajjewels.jinirajjewels;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rashil on 11/3/18.
 */

public class EarringsPhoto implements Parcelable {
    private String mUrl;
    private String mTitle;

    public EarringsPhoto(String url, String title) {
        mUrl = url;
        mTitle = title;
    }

    protected EarringsPhoto(Parcel in) {
        mUrl = in.readString();
        mTitle = in.readString();
    }

    public static final Creator<EarringsPhoto> CREATOR = new Creator<EarringsPhoto>() {
        @Override
        public EarringsPhoto createFromParcel(Parcel in) {
            return new EarringsPhoto(in);
        }

        @Override
        public EarringsPhoto[] newArray(int size) {
            return new EarringsPhoto[size];
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

    public static  EarringsPhoto[] getSpacePhotos() {

        return new EarringsPhoto[]{
                new EarringsPhoto("https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/earring1.jpg?alt=media&token=9dedc7a8-cbc1-448f-b1fc-4aab60b90ff3", "Earring1"),
                new EarringsPhoto("https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/earring2.jpg?alt=media&token=4ca6f49b-3678-4f17-8927-bb733cd053fd", "Earring2"),
                new EarringsPhoto("https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/earring3.jpg?alt=media&token=6391fc18-6fa6-4a03-ab43-335f814b1d84", "Earring3"),
                new EarringsPhoto("https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/earring4.jpg?alt=media&token=b0110a68-50be-4732-82a8-4ce7239716cf", "Earring4"),
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
