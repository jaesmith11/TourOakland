package com.example.android.touroakland;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


/**
 * Created by James on 5/22/18.
 */

public class DetailActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Use custom toolbar_main.xml resource
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Apply xml style res to customize font
        toolbar.setTitleTextAppearance(this, R.style.ToolbarFont);

        //Declare & initialize variables to be extracted from Bundle
        String mLocationName = null;
        String mlatitude = null;
        String mlongitude = null;

        //Create instances of views to populate info in activity_detail.xml
        TextView mLocation = findViewById(R.id.detail_location);
        TextView mAddress = findViewById(R.id.detail_neighborhood);
        TextView mDateEst = findViewById(R.id.detail_date_est);
        ImageView mMapImage = findViewById(R.id.detail_image);


        //Extract data from intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String location = (String) extras.get(getString(R.string.location_key));
            mLocation.setText(location);
            mLocationName = location;

            String address = (String) extras.get(getString(R.string.address_key));
            mAddress.setText(address);

            String dateEst = (String) extras.get(getString(R.string.date_key));
            mDateEst.setText(dateEst);

            mlatitude = (String) extras.get(getString(R.string.latitude_key));
            mlongitude = (String) extras.get(getString(R.string.longitude_key));
        }

        //Use the lat/long coords provided by the Intent bundle to display a static map image
        if (((mlatitude) != null) && ((mlongitude) != null)) {
            Glide.with(this)
                    .load("http://maps.google.com/maps/api/staticmap?center=" +
                            mlatitude + "," + mlongitude +
                            "&zoom=17&size=359x300&markers=color:purple%7Clabel:S%7C"
                            + mlatitude + "," + mlongitude)
                    .apply(new RequestOptions()
                            .centerCrop())
                    .into(mMapImage);
        }

        //Use the lat/long coords provided by the Intent bundle to provide a search query Uri
        final Uri gmmIntentUri = Uri.parse("geo:" + mlatitude + ","
                + mlongitude + "?q=" + Uri.encode(mLocationName));

        //Set a listener on the map image so a map intent opens up with the appropriate Uri
        mMapImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });

    }

}
