package jeyts.uflapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import jeyts.uflapplication.R;
import jeyts.uflapplication.Model.MyDataModel;

import java.util.List;

public class SchedArrayAdapter extends ArrayAdapter<MyDataModel> {

    List<MyDataModel> modelList;
    Context context;
    private LayoutInflater mInflater;

    // Constructors
    public SchedArrayAdapter(Context context, List<MyDataModel> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        modelList = objects;
    }

    @Override
    public MyDataModel getItem(int position) {
        return modelList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.layout_row_view, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        MyDataModel item = getItem(position);

        vh.textViewDate.setText(item.getDate());
        vh.textViewDateDetails.setText(item.dateDetails());




        return vh.rootView;
    }

    /**
     * ViewHolder class for layout.<br />
     * <br />
     * Auto-created on 2016-01-05 00:50:26 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private static class ViewHolder {
        public final RelativeLayout rootView;

        public final TextView textViewDate;
        public final TextView textViewDateDetails;
        private ViewHolder(RelativeLayout rootView, TextView textViewDate, TextView textViewDateDetails){
            this.rootView = rootView;
            this.textViewDate = textViewDate;
            this.textViewDateDetails = textViewDateDetails;

        }

        public static ViewHolder create(RelativeLayout rootView) {
            TextView TextViewDate = (TextView) rootView.findViewById(R.id.textViewName);
            TextView TextViewDateDetails = (TextView) rootView.findViewById(R.id.textViewCompletions);


            return new ViewHolder(rootView, TextViewDate, TextViewDateDetails);
        }
    }
}
