package com.riaytech.saludinteligente.location;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

public class LocationService {
    private FusedLocationProviderClient fusedLocationClient;

    public LocationService(Context ctx) {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(ctx);
    }

    @SuppressLint("MissingPermission")
    public void getLastLocation(LocationCallback callback) {
        fusedLocationClient.getLastLocation().addOnSuccessListener(location -> {
            if (location != null) {
                callback.onLocation(location);
            } else {
                Log.w("LocationService", "Location is null");
            }
        }).addOnFailureListener(e -> Log.e("LocationService", "Error getting location", e));
    }

    public interface LocationCallback {
        void onLocation(Location location);
    }
}
