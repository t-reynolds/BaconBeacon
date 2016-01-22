package com.xanderfehsenfeld.baconbeacon;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

/* A service to periodically update the location and send to a server */

//public class MyService extends Service implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
public class MyService extends Service {

    /* location */
    //private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;



    public MyService() {}

    /* get the most current location */
//    public void updateLocation(){
//        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
//
//    }

    @Override
    public int onStartCommand( Intent intent, int flags, int startId) {
        Context c = getApplicationContext();
        Toast toast = Toast.makeText(c, "service started!", Toast.LENGTH_SHORT);
        toast.setText("service started!");
        toast.show();
//        buildGoogleApiClient();
//        mGoogleApiClient.connect();
        Locator locator = new Locator(this);
        locator.updateLocation();
        String message = R.string.message;

        /* start alarm to periodically update location & contact server */

        return Service.START_NOT_STICKY;
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");

    }

//    /* build a googleApiClient */
//    protected synchronized void buildGoogleApiClient() {
//        mGoogleApiClient = new GoogleApiClient.Builder( this )
//                .addConnectionCallbacks( this )
//                .addOnConnectionFailedListener( this )
//                .addApi( LocationServices.API )
//                .build();
//    }
//
//
//    @Override
//    public void onConnected(Bundle bundle) {
//
//    }
//
//    @Override
//    public void onConnectionSuspended(int i) {
//
//    }
//
//    @Override
//    public void onConnectionFailed(ConnectionResult connectionResult) {
//
//    }
}
