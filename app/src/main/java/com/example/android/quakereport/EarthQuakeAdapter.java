package com.example.android.quakereport;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import com.example.android.quakereport.EarthQuakeData;
import com.example.android.quakereport.R;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class EarthQuakeAdapter extends ArrayAdapter<EarthQuakeData> {


    public EarthQuakeAdapter(@NonNull Context context,  @NonNull List objects) {
        super(context, 0, objects);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View dataView;
        dataView = convertView;
        if(dataView == null)
        {
            dataView = LayoutInflater.from(getContext()).inflate(R.layout.activity_earthquake_row,parent,false);
        }
        // Get the appropriate background color based on the current earthquake magnitude
        EarthQuakeData currentData = getItem(position);
        int magnitudeColor = getMagnitudeColor(Objects.requireNonNull(currentData).getQuakeMagnitude());
        TextView quakeMag = dataView.findViewById(R.id.magnitude);
        GradientDrawable magnitudeCircle = (GradientDrawable) quakeMag.getBackground();
         //Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        quakeMag.setText(formatMagnitude(currentData.getQuakeMagnitude()));
        String string = currentData.getQuakeLocation();
        String part1;
        String part2;
        if(string.contains("of")) {
            String[] parts = string.split("of");
            part1 = parts[0] + "of";
            part2 = parts[1];
        }else
        {
            part1 = getContext().getResources().getString(R.string.near_the);
            part2 = currentData.getQuakeLocation();
        }
        TextView quakeLoc = dataView.findViewById(R.id.location);
        quakeLoc.setText(part1);
        TextView quakePlace = dataView.findViewById(R.id.place);
        quakePlace.setText(part2);
        TextView quakeTime = dataView.findViewById(R.id.quaketime);
        quakeTime.setText(currentData.getQuakeTime());
        TextView quakeDate = dataView.findViewById(R.id.quakedate);
        quakeDate.setText(currentData.getQuakeDate());



        return dataView;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            magnitudeFormat = new DecimalFormat("0.0");
        }
            return magnitudeFormat.format(magnitude);

    }

    private  Integer getMagnitudeColor(double magnitude)
    {
        int color;
        switch ((int) magnitude)
        {
            case 1:color = ContextCompat.getColor(getContext(), R.color.magnitude1);
                   break;
            case 2:color = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case 3:color = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case 4 :color = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case 5 :color = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case 6 :color = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case 7 :color = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case 8 :color = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case 9 :color = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            default:color = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;
        }
        return color;

    }
}
