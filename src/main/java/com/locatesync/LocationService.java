package com.locatesync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

public class LocationService extends Service {

    private LocationManager locationManager;
    private LocationListener locationListener;

    @Override
    public void onCreate() {
        super.onCreate();
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                // Send location data to the backend
                sendLocationToServer(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {}

            @Override
            public void onProviderEnabled(String provider) {}

            @Override
            public void onProviderDisabled(String provider) {}
        };
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 900000, 0, locationListener); // 15 minutes interval
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return START_STICKY;
    }

    private void sendLocationToServer(Location location) {
        // Send location data to the backend
        // You can use HTTP or WebSocket to communicate with your web server
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        locationManager.removeUpdates(locationListener);
        super.onDestroy();
    }
}
