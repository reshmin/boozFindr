package com.reshmi.work.btappproto2.model;

import com.reshmi.work.btappproto2.R;

public class EventList {
    private static final int MAX_NUM_EVENTS = 5;
    private int mNoOfEvents;
    private EventDetails[] mBeerTastingEventList = new EventDetails[MAX_NUM_EVENTS];
    private EventDetails[] mWineTastingEventList = new EventDetails[MAX_NUM_EVENTS];
    private EventDetails[] mHardLiquorTastingEventList = new EventDetails[MAX_NUM_EVENTS];
    private EventDetails[] mOtherEventList = new EventDetails[MAX_NUM_EVENTS];
    private static EventList beerTastingEventInstance = null;
    private static EventList wineTastingEventInstance = null;
    private static EventList hardLiqourTastingEventInstance = null;
    private static EventList otherEventInstance = null;
    //private static EventList instance = null;

    public static EventList getBeerTastingEventInstance()
    {
        return beerTastingEventInstance;
    }

    public static EventList getWineTastingEventInstance()
    {
        return wineTastingEventInstance;
    }

    public static EventList getHardLiqourTastingEventInstance()
    {
        return hardLiqourTastingEventInstance;
    }

    public static EventList getOtherEventInstance()
    {
        return otherEventInstance;
    }

    public static EventList getInstance(int typeOfEvent)
    {
        /*
        if(instance == null)
        {
            instance = new EventList(typeOfEvent);
        }
        return instance;
       */
        switch (typeOfEvent) {
            case 0:
                if (beerTastingEventInstance == null) {
                    beerTastingEventInstance = new EventList(typeOfEvent);
                }
                return beerTastingEventInstance;
            case 1:
                if (wineTastingEventInstance == null) {
                    wineTastingEventInstance = new EventList(typeOfEvent);
                }
                return wineTastingEventInstance;
            case 2:
                if (hardLiqourTastingEventInstance == null) {
                    hardLiqourTastingEventInstance = new EventList(typeOfEvent);
                }
                return hardLiqourTastingEventInstance;
            case 3:
                if (otherEventInstance == null) {
                    otherEventInstance = new EventList(typeOfEvent);
                }
                return otherEventInstance;
            default:
                return null;
        }
    }

    public EventDetails[] getBeerTastingEventList() {
        return mBeerTastingEventList;
    }

    public EventDetails[] getWineTastingEventList() {
        return mWineTastingEventList;
    }

    public EventDetails[] getHardLiquorTastingEventList() {
        return mHardLiquorTastingEventList;
    }

    public EventDetails[] getOtherEventList() {
        return mOtherEventList;
    }

    protected EventList (int typeOfEvent)
    {
        mNoOfEvents = MAX_NUM_EVENTS;
        switch (typeOfEvent)
        {
            case 0: //Beer Tasting Events
            {
                mBeerTastingEventList[0]= new EventDetails("Battle of the Brews Event ",
                        0,
                        "\n House Beer \n Address: \n 219 Rose Ave, \n Venice, CA 90291 \n",
                        5,
                        "https://housebeer.us/",
                        "01234567899",
                        R.drawable.img1);
                mBeerTastingEventList[1] = new EventDetails("Sip and Swish Beer Tasting Event",
                        1,
                        "\n Hangar 24 Craft Brewery \n Address: \n1710 Sessums Dr,\n Redlands, CA 92374 \n",
                        4,
                        "http://www.hangar24brewery.com/",
                        "9093891400",
                        R.drawable.beer1);
                mBeerTastingEventList[2] = new EventDetails("Chug-a-beer Event",
                        2,
                        "\n Flights Beer Bar \n Address: \n 5119 W El Segundo Blvd,\n Hawthorne, CA 90250\n",
                        4,
                        "http://flightsbeerbar.com/",
                        "3106768228",
                        R.drawable.images);
                mBeerTastingEventList[3] = new EventDetails("Motley Brew Event",
                        3,
                        "\n Craft Beer Club \n Address: \n 32 Anacapa St,\n Santa Barbara, CA 93101\n",
                        4,
                        "https://www.craftbeerclub.com", "8002002959",
                        R.drawable.img3);
                mBeerTastingEventList[4] = new EventDetails("Beer Taste Fest",
                        4,
                        "\n Bagby Beer Company \n Address: \n 601 S Coast Hwy, \n Oceanside, CA 92054\n",
                        4,
                        "http://places.singleplatform.com/bagby-beer-company/menu?ref=google", "(760) 270-9075)",
                        R.drawable.image2);
                break;
            }
            case 1: //Wine Tasting Events
            {
                mWineTastingEventList[0]= new EventDetails("Wine & Dine Event ",
                        0,
                        "\n House Beer \n Address: \n 219 Rose Ave, \n Venice, CA 90291 \n",
                        5,
                        "https://housebeer.us/",
                        "01234567899",
                        R.drawable.image8);
                mWineTastingEventList[1] = new EventDetails("Wine Tasting Event 1",
                        1,
                        "\n Rancho Bernardo Winery \n Address: \n1710 Sessums Dr,\n Redlands, CA 92374 \n",
                        4,
                        "http://www.hangar24brewery.com/",
                        "9093891400",
                        R.drawable.image9);
                mWineTastingEventList[2] = new EventDetails("Wine Tasting Event 2",
                        2,
                        "\n Flights Beer Bar \n Address: \n 5119 W El Segundo Blvd,\n Hawthorne, CA 90250\n",
                        4,
                        "http://flightsbeerbar.com/",
                        "3106768228",
                        R.drawable.images);
                mWineTastingEventList[3] = new EventDetails("Wine Tasting Event 3",
                        3,
                        "\n Craft Beer Club \n Address: \n 32 Anacapa St,\n Santa Barbara, CA 93101\n",
                        4,
                        "https://www.craftbeerclub.com", "8002002959",
                        R.drawable.image4);
                mWineTastingEventList[4] = new EventDetails("Wine Tasting Event 4",
                        4,
                        "\n Bagby Beer Company \n Address: \n 601 S Coast Hwy, \n Oceanside, CA 92054\n",
                        4,
                        "http://places.singleplatform.com/bagby-beer-company/menu?ref=google", "(760) 270-9075)",
                        R.drawable.img1);
                break;
            }
            case 2: //Hard Liquor Tasting Events
                mHardLiquorTastingEventList = null;
                break;
            case 3: //Other events
                mOtherEventList = null;
                break;
        }

    }

    void EventList(int noOfEvents, EventDetails[] eventDetailsList)
    {
        mNoOfEvents = noOfEvents;
        //mEventList = eventDetailsList;
    }

    public String [] getEventTitles(int typeOfEvent)
    {
        String[] eventTitles = new String[mNoOfEvents];

        for (int i=0; i<mNoOfEvents; i++) {
            switch (typeOfEvent) {
                case 0:
                    eventTitles[i] = mBeerTastingEventList[i].getEventTitle();
                    break;
                case 1:
                    eventTitles[i] = mWineTastingEventList[i].getEventTitle();
                    break;
                case 2:
                    eventTitles[i] = mHardLiquorTastingEventList[i].getEventTitle();
                    break;
                case 3:
                    eventTitles[i] = mOtherEventList[i].getEventTitle();
                    break;
                default:
                    break;
            }
        }

        return eventTitles;
    }

    public EventDetails getEvent(int typeOfEvent, int eventId)
    {
        switch (typeOfEvent) {
            case 0:
                return mBeerTastingEventList[eventId];
            case 1:
                return mWineTastingEventList[eventId];
            case 2:
                return mHardLiquorTastingEventList[eventId];
            case 3:
                return mOtherEventList[eventId];
        }
        return null;
    }
}
