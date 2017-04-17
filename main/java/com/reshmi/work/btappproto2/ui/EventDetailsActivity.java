package com.reshmi.work.btappproto2.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.reshmi.work.btappproto2.R;
import com.reshmi.work.btappproto2.model.EventDetails;
import com.reshmi.work.btappproto2.model.EventList;

public class EventDetailsActivity extends AppCompatActivity {
    public static final String TAG = EventDetailsActivity.class.getSimpleName();
    private ImageView mEventDetailsImageView;
    private TextView mEventAddressTextView;
    private TextView mTitleTextView;
    private RatingBar mRatingBar;
    private Button mWebsiteButton;
    private Button mDirectionsButton;
    private Button mCallButton;
    private int mEventId;
    private int mTypeOfEvent;
    EventDetails mEventDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        String item = getIntent().getStringExtra("ITEM");
        mTypeOfEvent = getIntent().getIntExtra("TYPEOFEVENT", 0);
        mEventId = getIntent().getIntExtra("EVENTID",0);

        Log.d(TAG, "Invoked Event Details Activity");
        Log.d(TAG, "Position value obtained is " + mEventId);


        //position field will determine which type of event
        EventList eventList = EventList.getInstance(mTypeOfEvent);
        mEventDetails = eventList.getEvent(mTypeOfEvent, mEventId);

        mEventDetailsImageView = (ImageView) findViewById(R.id.eventImageView);
        int imagePathResId = mEventDetails.getEventImageResId();
        mEventDetailsImageView.setImageResource(imagePathResId);

        mEventAddressTextView = (TextView) findViewById(R.id.eventAddressTextView);
        mEventAddressTextView.setText(mEventDetails.getEventAddress());

        mTitleTextView = (TextView) findViewById(R.id.eventTitleTextView);
        mTitleTextView.setText(mEventDetails.getEventTitle());

        mWebsiteButton = (Button) findViewById(R.id.websiteLinkButton);
        mDirectionsButton = (Button) findViewById(R.id.directionsButton);
        mCallButton = (Button) findViewById(R.id.callButton);

        addListenerOnRatingBar();
        addListenerOnButtons();
    }

    public void addListenerOnButtons()
    {
        mWebsiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebsite();
                }
        });

        mDirectionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMapsApp();
            }
        });

        mCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPhoneDialerApp();
            }
        });

    }

    private void openMapsApp()
    {
        String map = "http://maps.google.co.in/maps?q=" + mEventDetails.getEventAddress();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
        startActivity(intent);
    }

    private void openPhoneDialerApp()
    {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        String tel = "tel:"+ mEventDetails.getPhoneNo();
        intent.setData(Uri.parse(tel));
        startActivity(intent);
    }

    private void openWebsite()
    {
        //Extract website link from EventDetails object
        //EventList eventDetailsList = new EventList();
        //EventDetails currEvent = eventDetailsList.getEvent(mEventId);

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mEventDetails.getWebsiteUrl()));
        startActivity(browserIntent);
    }

    public void addListenerOnRatingBar() {

        mRatingBar = (RatingBar) findViewById(R.id.ratingBar);
        //txtRatingValue = (TextView) findViewById(R.id.txtRatingValue);

        //if rating value is changed,
        //display the current rating value in the result (textview) automatically
        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                //txtRatingValue.setText(String.valueOf(rating));
                //Should display current rating value and update if you click and would like to set rating.

            }
        });
    }
}
