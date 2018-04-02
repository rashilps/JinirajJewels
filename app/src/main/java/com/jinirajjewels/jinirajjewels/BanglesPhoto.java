package com.jinirajjewels.jinirajjewels;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rashil on 11/3/18.
 */

public class BanglesPhoto implements Parcelable {
        private String mUrl;
        private String mTitle;

        public BanglesPhoto(String url, String title) {
            mUrl = url;
            mTitle = title;
        }

        protected BanglesPhoto(Parcel in) {
            mUrl = in.readString();
            mTitle = in.readString();
        }

        public static final Creator<BanglesPhoto> CREATOR = new Creator<BanglesPhoto>() {
            @Override
            public BanglesPhoto createFromParcel(Parcel in) {
                return new BanglesPhoto(in);
            }

            @Override
            public BanglesPhoto[] newArray(int size) {
                return new BanglesPhoto[size];
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

        public static  BanglesPhoto[] getSpacePhotos() {

            return new BanglesPhoto[]{
                    new BanglesPhoto("https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/bangles1.jpg?alt=media&token=fc9f1904-f4e9-4aca-a58b-31735ea77137", "Bangle1"),
                    new BanglesPhoto("https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/bangles2.jpg?alt=media&token=e7adfdc3-f24f-4a90-8bd3-a6578e77df56", "Bangle2"),
                    new BanglesPhoto("https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/bangles3.jpg?alt=media&token=d72f94bb-b28d-41cb-bd47-915ca4b0dc7f", "Bangle3"),
                    new BanglesPhoto("https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/bangles4.jpg?alt=media&token=99f7e3ff-4789-480f-b284-a0b3c13f0d0a", "Bangle4"),
                    new BanglesPhoto("https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/bangles5.jpg?alt=media&token=520fa3fb-cee8-4ec9-b711-dce73facc383", "Bangle5"),
                    new BanglesPhoto("https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/bangles6.jpg?alt=media&token=c2b605aa-63e6-4e5c-8939-ad69f514ac5e", "Bangle6"),
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
