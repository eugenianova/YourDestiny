package com.example.pract.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.pract.R;
import com.example.pract.viewmodel.Activity_List;

import java.util.ArrayList;

public class RaidAdapter extends ArrayAdapter<Activity_List> {

    private Context mContext;
    private int mResourse;

    public RaidAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Activity_List> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResourse = resource;
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResourse, parent, false);

        ImageView imageView = convertView.findViewById(R.id.image);
        TextView textView = convertView.findViewById(R.id.text_list_res);

        imageView.setImageResource(getItem(position).getImage());
        textView.setText(getItem(position).getTitle());

        return convertView;
    }
}
