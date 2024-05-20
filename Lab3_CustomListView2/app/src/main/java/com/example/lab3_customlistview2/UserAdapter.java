package com.example.lab3_customlistview2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class UserAdapter extends ArrayAdapter<Users> {

    private Context mContext;
    private int mResource;
    public UserAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Users> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource, parent, false);

        ImageView imageAvatar = convertView.findViewById(R.id.imageAvatar);

        ImageView imageFlag = convertView.findViewById(R.id.imageFlag);

        TextView txtName = convertView.findViewById(R.id.txtName);

        TextView txtDes = convertView.findViewById(R.id.txtDes);

        imageAvatar.setImageResource(getItem(position).getAvatar());
        imageFlag.setImageResource(getItem(position).getFlag());

        txtName.setText((getItem(position).getName()));

        txtDes.setText((getItem(position).getDescription()));

        return convertView;
    }
}
