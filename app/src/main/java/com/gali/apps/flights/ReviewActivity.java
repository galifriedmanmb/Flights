package com.gali.apps.flights;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ReviewActivity extends AppCompatActivity {

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        Intent intent = getIntent();
        Flight f = intent.getParcelableExtra("flight");
        ((TextView)findViewById(R.id.countryET)).setText(f.country);
        ((TextView)findViewById(R.id.cityET)).setText(f.city);
        ((TextView)findViewById(R.id.currencyET)).setText(f.currency);
        ((TextView)findViewById(R.id.priceET)).setText(f.price);

        findViewById(R.id.backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        String bgColor = preferences.getString("reviewBGCKey","white");
        findViewById(R.id.activity_review).setBackgroundColor(Color.parseColor(bgColor));

    }
}
