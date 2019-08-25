package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    Context context;
    List<Earthquake> earthquakes;

    /**
     * Constructs a new {@link EarthquakeAdapter}.
     *
     * @param context     of the app
     * @param earthquakes is the list of earthquakes, which is the data source of the adapter
     */
    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
        this.context = context;
        this.earthquakes = earthquakes;
    }

    class MyViewHolder{
        TextView magnitude_tv;
        TextView date_tv;
        TextView location_tv;

        public MyViewHolder(View view) {
            magnitude_tv = (TextView) view.findViewById(R.id.magnitude_tv);
            date_tv = (TextView) view.findViewById(R.id.date_tv);
            location_tv = (TextView) view.findViewById(R.id.location_tv);
        }
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row = convertView;
        MyViewHolder holder = null;
        if(row==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = (LinearLayout) inflater.inflate(R.layout.single_item, parent, false);
            holder = new MyViewHolder(row);
            row.setTag(holder);
            Log.d("Abhi","Creating new row");
        }
        else{
            holder = (MyViewHolder) row.getTag();
            Log.d("Abhi","Recycling View");
        }

        holder.magnitude_tv.setText(Double.toString(earthquakes.get(position).magnitude));
        holder.date_tv.setText(earthquakes.get(position).date);
        holder.location_tv.setText(earthquakes.get(position).location);

        return row;
    }
}
