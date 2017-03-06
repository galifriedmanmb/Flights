package com.gali.apps.flights;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.widget.Toast;

/**
 * Created by 1 on 3/4/2017.
 */

public class FlightsPreferenceActivity extends PreferenceActivity {
    SharedPreferences preferences;
    String[] currencys;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);
        preferences = PreferenceManager.getDefaultSharedPreferences(FlightsPreferenceActivity.this);


        findPreference("currencyKey").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                String newCurrency = (String)newValue;
                if (!Constants.legalCurrency(newCurrency)) {
                    Toast.makeText(FlightsPreferenceActivity.this,Constants.currenciesMessage,Toast.LENGTH_SHORT).show();
                    return false;
                }
                return true;
            }
        });

        findPreference("orderBGCKey").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                String newColor = (String)newValue;
                if (!Constants.legalColor(newColor)) {
                    Toast.makeText(FlightsPreferenceActivity.this,Constants.colorsMessage,Toast.LENGTH_SHORT).show();
                    return false;
                }
                return true;
            }
        });

        findPreference("reviewBGCKey").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                String newColor = (String)newValue;
                if (!Constants.legalColor(newColor)) {
                    Toast.makeText(FlightsPreferenceActivity.this,Constants.colorsMessage,Toast.LENGTH_SHORT).show();
                    return false;
                }
                return true;
            }
        });

        findPreference("exit").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                finish();
                return true;
            }
        });
    }


}
