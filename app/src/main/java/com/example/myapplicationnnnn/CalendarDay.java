package com.example.myapplicationnnnn;

import android.net.Uri;

public class CalendarDay {
    private int year;
    private int month;
    private int day;
    private Uri imageUri;
    private boolean isCurrentMonth;

    public CalendarDay(int year, int month, int day, Uri imageUri, boolean isCurrentMonth) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.imageUri = imageUri;
        this.isCurrentMonth = isCurrentMonth;
    }

    public int getDay() {
        return day;
    }

    public boolean isCurrentMonth() {
        return isCurrentMonth;
    }

    public Uri getImageUri() {
        return imageUri;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }

    public void setCurrentMonth(boolean currentMonth) {
        isCurrentMonth = currentMonth;
    }
}