package com.xanderfehsenfeld.baconbeacon;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

/**
 * Created by Xander on 1/21/16.
 *
 * A class to contain a google api client, which captures the location
 */
public class Locator implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    public Location mLastLocation;
    private GoogleApiClient mGoogleApiClient;
    private Context context;

    public Locator( Context _context){
        buildGoogleApiClient( _context );
        context = _context;
        mGoogleApiClient.connect();
        updateLocation();


    }

    /* get the most current location */
    public void updateLocation(){
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

    }

    /* build a googleApiClient */
    protected synchronized void buildGoogleApiClient(Context context) {
        mGoogleApiClient = new GoogleApiClient.Builder( context )
                .addConnectionCallbacks( this )
                .addOnConnectionFailedListener( this )
                .addApi( LocationServices.API )
                .build();
    }

    @Override
    public void onConnected(Bundle bundle) {


    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}
