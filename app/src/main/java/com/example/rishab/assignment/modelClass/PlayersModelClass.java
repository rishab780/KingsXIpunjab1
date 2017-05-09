package com.example.rishab.assignment.modelClass;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rishab on 20-04-2017.
 */

public class PlayersModelClass implements Parcelable {
    public static final Creator<PlayersModelClass> CREATOR = new Creator<PlayersModelClass>() {
        @Override
        public PlayersModelClass createFromParcel(final Parcel in) {
            return new PlayersModelClass(in);
        }

        @Override
        public PlayersModelClass[] newArray(final int size) {
            return new PlayersModelClass[size];
        }
    };


    private String mName;

    /**
     *
     * @param in sending in
     */
    protected PlayersModelClass(final Parcel in) {
        mName = in.readString();
    }



    /**
     *
     * @param mName name
     */
    public PlayersModelClass(final String mName) {
        this.mName = mName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(mName);

    }

    /**
     *
     * @return name
     */
    public String getmName() {
        return mName;
    }

    /**
     *
     * @param mName name
     */

    public void setmName(final String mName) {
        this.mName = mName;
    }
}
