package com.example.culturalmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class Map_Fragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map_,container,false);
        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.MY_MAP);
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    ArrayList<LatLng>arrayList=new ArrayList<LatLng>();
                    LatLng Bidholi = new LatLng(30.4092, 77.9693);
                    LatLng Kandoli = new LatLng(30.344524665123163, 78.06987794610541);
                    LatLng Kharakhet = new LatLng(30.4151, 77.9730);
                    LatLng Pondha = new LatLng(30.3695,77.9710);
                    LatLng Majhaun = new LatLng(30.3763,77.9824);

                    @Override
                    public void onMapClick(@NonNull LatLng latLng) {
                        MarkerOptions markerOptions = new MarkerOptions();
                        arrayList.add(Bidholi);
                        arrayList.add(Kandoli);
                        arrayList.add(Pondha);
                        arrayList.add(Kharakhet);
                        arrayList.add(Majhaun);
                        googleMap.clear();
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,20));
                        googleMap.addMarker(markerOptions);
                    }
                });
            }
        });
        return view;
    }
}
