package com.example.android.touroakland;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

/**
 * Created by James on 5/22/18.
 */

public class DestinationAdapter extends ArrayAdapter<Destination> {

    //This variable holds the image for each destination in the list view
    private int mImageResID;

    public DestinationAdapter(@NonNull Context context, @NonNull ArrayList<Destination> destinations) {
        super(context, 0, destinations);


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        //Find current list item
        Destination currentSite = getItem(position);

        //Find image resource for destination
        if (currentSite != null) {
            mImageResID = currentSite.getImageResID();
        }

        // Find the ImageView in list_item.xml that will contain the destination's image
        ImageView textContainer = listItemView.findViewById(R.id.card);

        // Use the Glide library to load and crop the image
        Glide.with(getContext())
                .load(mImageResID)
                .apply(new RequestOptions()
                        //.placeholder(R.mipmap.ic_launcher)
                .centerCrop())
                .into(textContainer);

        //Find the TV in the list_item.xml and set appropriate location name
        TextView locationName = (TextView) listItemView.findViewById(R.id.location_name_tv);
        locationName.setText(currentSite.getLocationName());


        return listItemView;
    }

}

