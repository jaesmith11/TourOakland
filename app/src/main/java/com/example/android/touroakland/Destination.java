package com.example.android.touroakland;

/**
 * Created by James on 5/22/18.
 */

public class Destination {
    private String mLocationName;
    private String mNeighborhood;
    private int mImageResID;
    private String mLatitude;
    private String mLongitude;
    private String mDateEst;


    //private String mWebsite;


    public Destination(String vLocationName, String vNeighborhood, int vImageResID, String vLatitude, String vLongitude, String vDateEst){
        mLocationName = vLocationName;
        mNeighborhood = vNeighborhood;
        mImageResID = vImageResID;
        mLatitude = vLatitude;
        mLongitude = vLongitude;
        mDateEst = vDateEst;

    }


    public String getLocationName() {
        return mLocationName;
    }

    public String getNeighborhood() {
        return mNeighborhood;
    }

    public int getImageResID() {
        return mImageResID;
    }

    public String getLatitude(){return mLatitude;}

    public String getLongitude(){return mLongitude;}

    public String getDateEst(){return mDateEst;}


    @Override
    public String toString(){
        return "Destination{" +
                "mLocationName='" + mLocationName + '\'' +
                "mAddress='" + mNeighborhood + '\'' +
                "mImageResID'" + mImageResID  +
                '}';
    }

}
