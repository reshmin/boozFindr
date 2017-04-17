package com.reshmi.work.btappproto2.model;

public class EventDetails {
    private int mEventId; //same as position of event in event list displayed at this point
    private String mEventTitle;
    private String mEventAddress;
    private int mCurrentRating;
    private String mWebsiteUrl;
    private String mPhoneNo;
    private int mEventImageResId;



    public EventDetails (String eventTitle,
                         int eventId,
                         String eventAddress,
                         int currentRating,
                         String websiteUrl,
                         String phoneNo,
                         int eventImageResId)
    {
        mEventTitle      = eventTitle;
        mEventId         = eventId;
        mEventAddress    = eventAddress;
        mCurrentRating   = currentRating;
        mWebsiteUrl      = websiteUrl;
        mPhoneNo         = phoneNo;
        mEventImageResId = eventImageResId;
    }

    public String getEventTitle() {
        return mEventTitle;
    }

    public void setEventTitle(String eventTitle) {
        mEventTitle = eventTitle;
    }

    public int getEventId() {
        return mEventId;
    }

    public void setEventId(int eventId) {
        mEventId = eventId;
    }

    public String getEventAddress() {
        return mEventAddress;
    }

    public void setEventAddress(String eventAddress) {
        mEventAddress = eventAddress;
    }

    public int getCurrentRating() {
        return mCurrentRating;
    }

    public void setCurrentRating(int currentRating) {
        mCurrentRating = currentRating;
    }

    public String getWebsiteUrl() {
        return mWebsiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        mWebsiteUrl = websiteUrl;
    }

    public String getPhoneNo() {
        return mPhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        mPhoneNo = phoneNo;
    }

    public int getEventImageResId() {
        return mEventImageResId;
    }

    public void setEventImageResId(int eventImageResId) {
        mEventImageResId = eventImageResId;
    }

}
