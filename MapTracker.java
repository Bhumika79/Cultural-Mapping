package com.example.culturalmap;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MapTracker extends AppCompatActivity {
    EditText etSource, etDestination;
    Button btTrack;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_tracker);
        etSource = findViewById(R.id.et_source);
        etDestination = findViewById(R.id.bt_track);
        btTrack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String sSource = etSource.getText().toString().trim();
                String sDestination = etDestination.getText().toString();
                if (sSource.equals("") && sDestination.equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter both locations",Toast.LENGTH_SHORT).show();
                }else{
                    DisplayTrack(sSource, sDestination);
                }
            }
        });
    }
    private void DisplayTrack(String sSource,String sDestination){
        try{
            Uri uri = Uri.parse("https://www.google.co.in/maps/dir/" + sSource + "/" + sDestination);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}
