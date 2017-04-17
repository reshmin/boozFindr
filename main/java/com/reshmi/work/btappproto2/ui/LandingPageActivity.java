package com.reshmi.work.btappproto2.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.reshmi.work.btappproto2.R;

public class LandingPageActivity extends AppCompatActivity {
    private ListView mEvtCategoriesListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        mEvtCategoriesListView = (ListView) findViewById(R.id.eventCategoriesListView);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.mainToolbar);
        setSupportActionBar(myToolbar);

        // Defined Array values to show in ListView


        String[] eventCategories = new String[]{
                "\n    Beer Tasting Events",
                "\n    Wine Tasting Events",
                "\n    Hard Liquor Events",
                "\n    Other Events"
        };

        Integer [] imageIds = {R.drawable.img1,
                R.drawable.image9,
                R.drawable.image8,
                R.drawable.img3};

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        //       android.R.layout.simple_expandable_list_item_1, android.R.id.text1, eventCategories);
        CustomListAdapter adapter = new CustomListAdapter(this, eventCategories, imageIds);


        // Assign adapter to ListView
        mEvtCategoriesListView.setAdapter(adapter);

        mEvtCategoriesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                             @Override
                                             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                                 final String item = (String) parent.getItemAtPosition(position);
                                                 startEventListsActivity(item, position);
                                             }
                                         }
        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_actions, menu);

        return super.onCreateOptionsMenu(menu);
    }

    private void startEventListsActivity(String item, int position) {

        Intent intent = new Intent(this, EventListActivity.class);
        intent.putExtra("ITEM",item);
        intent.putExtra("POSITION",position);
        startActivity(intent);

    }

}
