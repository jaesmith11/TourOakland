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
public class ShopFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.destination_listview, container, false);

        final ArrayList<Destination> destinations = new ArrayList<Destination>();
        destinations.add(new Destination(getString(R.string.oaktown_spice), getString(R.string.grand_lake), R.drawable.spice_shop, "37.808998","-122.250592", getString(R.string.est_2011)));
        destinations.add(new Destination(getString(R.string.farmers_market), getString(R.string.grand_lake), R.drawable.grand_lake_farmers, "37.810855","-122.247815", getString(R.string.est_1998)));
        destinations.add(new Destination(getString(R.string.oaklandish), getString(R.string.downtown), R.drawable.oaklandish, "37.804887","-122.270635", getString(R.string.est_2000)));

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
            startActivity(detailIntent);
        }

    }
}
