package com.gali.apps.flights;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);


        findViewById(R.id.saveReviewBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String country = ((TextView)findViewById(R.id.countryET)).getText().toString();
                String city = ((TextView)findViewById(R.id.cityET)).getText().toString();
                String currency = ((TextView)findViewById(R.id.currencyET)).getText().toString();
                String price = ((TextView)findViewById(R.id.priceET)).getText().toString();
                Flight f = new Flight(country,city,currency,price);
                Intent intent = new Intent(MainActivity.this,ReviewActivity.class);
                intent.putExtra("flight",f);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        String bgColor = preferences.getString("orderBGCKey","white");
        findViewById(R.id.activity_main).setBackgroundColor(Color.parseColor(bgColor));

        String currency = preferences.getString("currencyKey","dollar");
        ((TextView)findViewById(R.id.currencyET)).setText(currency);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.settingsMI:
                Intent intent = new Intent(this, FlightsPreferenceActivity.class);
                startActivity(intent);
                break;
            case R.id.exitMI:
                finish();
        }
        return true;
    }
}
