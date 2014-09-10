package com.osacky.umbrella.ui.time;

import android.os.Parcel;
import android.os.Parcelable;

import org.joda.time.LocalTime;

public class TimeInfo implements Parcelable {

    public final LocalTime mLocalTime;

    public TimeInfo(LocalTime localTime) {
        mLocalTime = localTime;
    }

    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel destination, int flags) {
        destination.writeInt(mLocalTime.getMillisOfDay());
    }

    @SuppressWarnings("UnusedDeclaration")
    public static final Creator<TimeInfo> CREATOR = new Creator<TimeInfo>() {
        @Override public TimeInfo createFromParcel(Parcel parcel) {
            return new TimeInfo(LocalTime.fromMillisOfDay(parcel.readInt()));
        }

        @Override public TimeInfo[] newArray(int size) {
            return new TimeInfo[size];
        }
    };
}
