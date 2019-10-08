package com.example.jsonplaceholder.utility;

import android.content.Context;
import android.util.DisplayMetrics;

public class CalculateColumns {

    private static CalculateColumns columns;

    public static CalculateColumns getInstance() {
        if (columns == null)
            columns = new CalculateColumns();

        return columns;
    }

    public int calculateNoOfColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (dpWidth / 180);
        return noOfColumns;
    }

}
