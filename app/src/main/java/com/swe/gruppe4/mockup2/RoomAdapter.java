package com.swe.gruppe4.mockup2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kiesa on 28.10.2016.
 */

public class RoomAdapter extends ArrayAdapter<Room> {

    private ArrayList<Room> roomInfoList = new ArrayList<Room>();
    /**
     *  add Room object  to the adapter
     */
    public void add(Room room) {
        super.add(room);
        roomInfoList.add(room);

    }



    public Room getItem(int index) {
        return this.roomInfoList.get(index);
    }

    public RoomAdapter(Context context , int textViewResourceId){
        super(context,textViewResourceId);
    }

    /**
     *  this method is used to populate the Roomlist in the RoomActivity
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Room roomObj = getItem(position);
        if (convertView == null && roomObj.flag == false) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.room_box, parent, false);
        } else if(convertView == null && roomObj.flag == true){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.current_room_box, parent, false);
        }
        TextView roomName = (TextView) convertView.findViewById(R.id.roomName);
        roomName.setText(roomObj.getRoomName());
        TextView roomInfo = (TextView) convertView.findViewById(R.id.roomInfo);
        roomInfo.setText(roomObj.getRoomInfo());
        ImageView statusIcon = (ImageView) convertView.findViewById(R.id.statusImg);
        statusIcon.setImageResource(roomObj.getStatus());
        return convertView;
    }
}
