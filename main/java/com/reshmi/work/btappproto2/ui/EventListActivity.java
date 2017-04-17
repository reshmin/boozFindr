package com.reshmi.work.btappproto2.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.reshmi.work.btappproto2.R;
import com.reshmi.work.btappproto2.model.EventList;


public class EventListActivity extends AppCompatActivity {

    public static final String TAG = EventListActivity.class.getSimpleName();
    private ListView mListView;
    //private ExpandableListView mExpandableListView;
    private EventList mEventList;
    private int mTypeOfEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        mListView = (ListView) findViewById(R.id.eventListView);
        //mExpandableListView = (ExpandableListView) findViewById(R.id.expandableListView);

        mTypeOfEvent = getIntent().getIntExtra("POSITION",0);

        Log.d(TAG, "Position/Type Of Event value obtained is " + mTypeOfEvent);
        mEventList = EventList.getInstance(mTypeOfEvent);

        if (mEventList != null )
        {
            switch (mTypeOfEvent)
            {
                case 0:
                    if(mEventList.getBeerTastingEventList()!=null)
                        populateEventList();
                    else
                    { //No events found
                        //Add a TextView and display that No events were found
                        Toast.makeText(EventListActivity.this, "No Events found", Toast.LENGTH_LONG).show();
                    }
                    break;
                case 1:
                    if(mEventList.getWineTastingEventList()!=null)
                        populateEventList();
                    else
                    { //No events found
                        //Add a TextView and display that No events were found
                        Toast.makeText(EventListActivity.this, "No Events found", Toast.LENGTH_LONG).show();
                    }
                    break;
                case 2:
                    if(mEventList.getHardLiquorTastingEventList()!=null)
                        populateEventList();
                    else
                    { //No events found
                        //Add a TextView and display that No events were found
                        Toast.makeText(EventListActivity.this, "No Events found", Toast.LENGTH_LONG).show();
                    }
                    break;
                case 3:
                    if(mEventList.getOtherEventList()!=null)
                        populateEventList();
                    else
                    { //No events found
                        //Add a TextView and display that No events were found
                        Toast.makeText(EventListActivity.this, "No Events found", Toast.LENGTH_LONG).show();
                    }
                    break;
                default:
                    break;
            }
        }

    }

    private void populateEventList()
    {
        String[] evtTitles = mEventList.getEventTitles(mTypeOfEvent);

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, android.R.id.text1, evtTitles);


        // Assign adapter to ListView
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                             @Override
                                             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                                 final String item = (String) parent.getItemAtPosition(position);

                                                 if (item != null) {
                                                     //Toast.makeText(BeerTastingMapsActivity.this, item, Toast.LENGTH_LONG).show();
                                                     startEventDetailsActivity(item, position);
                                                 }


                                             }
                                         }
        );

    }

    private void startEventDetailsActivity(String item, int position) {
        Log.d(TAG, "Entered startEventDetailsActivity function");
        Intent intent = new Intent(this, EventDetailsActivity.class);
        intent.putExtra("ITEM",item);
        intent.putExtra("TYPEOFEVENT",mTypeOfEvent);
        intent.putExtra("EVENTID",position);
        startActivity(intent);

    }

}
