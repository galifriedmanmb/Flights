package com.gali.apps.flights;

/**
 * Created by 1 on 3/4/2017.
 */

public class Constants {
    static final String[] currencies = new String[]{"shekel","dollar","euro","GBP"};
    static final String[] colors = new String[]{"grey","blue","yellow","white"};

    static final String currenciesMessage = "legal currencies are: shekel, dollar, euro, GBP";
    static final String colorsMessage = "legal colors are: grey, blue, yellow, white";

    static boolean legalCurrency(String currency) {
        for (int i=0;i<currencies.length;i++) {
            if (currency.equals(currencies[i]))
                return true;
        }
        return false;
    }

    static boolean legalColor(String color) {
        for (int i=0;i<colors.length;i++) {
            if (color.equals(colors[i]))
            return true;
        }
        return false;
    }

}
