package com.gali.apps.flights;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 1 on 3/4/2017.
 */

public class Flight implements Parcelable{
    String country;
    String city;
    String currency;
    String price;

    public Flight(String country, String city, String currency, String price) {
        this.country = country;
        this.city = city;
        this.currency = currency;
        this.price = price;
    }

    protected Flight(Parcel in) {
        country = in.readString();
        city = in.readString();
        currency = in.readString();
        price = in.readString();
    }

    public static final Creator<Flight> CREATOR = new Creator<Flight>() {
        @Override
        public Flight createFromParcel(Parcel in) {
            return new Flight(in);
        }

        @Override
        public Flight[] newArray(int size) {
            return new Flight[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(country);
        dest.writeString(city);
        dest.writeString(currency);
        dest.writeString(price);
    }
}
