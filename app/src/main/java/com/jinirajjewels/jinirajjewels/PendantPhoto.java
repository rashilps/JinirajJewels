package com.jinirajjewels.jinirajjewels;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rashil on 11/3/18.
 */

public class PendantPhoto implements Parcelable {
    private String mUrl;
    private String mTitle;

    public PendantPhoto(String url, String title) {
        mUrl = url;
        mTitle = title;
    }

    protected PendantPhoto(Parcel in) {
        mUrl = in.readString();
        mTitle = in.readString();
    }

    public static final Creator<PendantPhoto> CREATOR = new Creator<PendantPhoto>() {
        @Override
        public PendantPhoto createFromParcel(Parcel in) {
            return new PendantPhoto(in);
        }

        @Override
        public PendantPhoto[] newArray(int size) {
            return new PendantPhoto[size];
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

    public static  PendantPhoto[] getSpacePhotos() {

        return new PendantPhoto[]{
                new PendantPhoto("https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/pendant1.jpg?alt=media&token=71858ac2-6287-42ce-88ee-640afd6268ca", "Space Shuttle"),
                new PendantPhoto("https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/pendant2.jpg?alt=media&token=92404035-00b6-44e8-b755-9a26b5217d1c", "Galaxy Orion"),
                new PendantPhoto("https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/pendant3.jpg?alt=media&token=284fb52a-8dec-4b74-a6e4-2ade55dfdb37", "Earth"),
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
