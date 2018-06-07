package com.example.android.touroakland;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.destination_listview, container, false);
        final ArrayList<Destination> destinations = new ArrayList<Destination>();
        destinations.add(new Destination(getString(R.string.good_mother), getString(R.string.downtown), R.drawable.good_mother, "37.803389", "-122.270572", getString(R.string.est_2015)));
        destinations.add(new Destination(getString(R.string.naming_gallery), getString(R.string.downtown), R.drawable.naming, "37.804142", "-122.267797", getString(R.string.est_2012)));
        destinations.add(new Destination(getString(R.string.one_am_generator), getString(R.string.downtown), R.drawable.one_am, "37.804985", "-122.268162", getString(R.string.est_2017)));

        //Create an instance of DestinationAdapter to populate the ListView
        DestinationAdapter adapter = new DestinationAdapter(getActivity(), destinations);

        ListView listView = (ListView) rootView.findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //Find the Destination that has been clicked on in the ListView
        Destination currentDestination = (Destination) getListView().getItemAtPosition(position);

        //Get information to populate the activity_detail.xml
        if (currentDestination != null) {
            String locationInfo = currentDestination.getLocationName();
            String neighborhoodInfo = currentDestination.getNeighborhood();
            String dateInfo = currentDestination.getDateEst();
            String toolbarInfo = getString(R.string.art_detailtb);

            //Retrieve coords for static map image
            String latInfo = currentDestination.getLatitude();
            String longInfo = currentDestination.getLongitude();

            Intent detailIntent = new Intent();
            detailIntent.setClass(getActivity(), DetailActivity.class);
            detailIntent.putExtra(getString(R.string.location_key), locationInfo);
            detailIntent.putExtra(getString(R.string.address_key), neighborhoodInfo);
            detailIntent.putExtra(getString(R.string.date_key), dateInfo);
            detailIntent.putExtra(getString(R.string.latitude_key), latInfo);
            detailIntent.putExtra(getString(R.string.longitude_key), longInfo);
            detailIntent.putExtra(getString(R.string.toolbar_key), toolbarInfo);
            startActivity(detailIntent);        }

    }
}
