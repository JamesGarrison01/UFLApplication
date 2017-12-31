package jeyts.uflapplication.Adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import jeyts.uflapplication.R;
import jeyts.uflapplication.Model.MyDataModel;

import java.util.List;

public class MyArrayAdapter extends ArrayAdapter<MyDataModel> {

    /**
     * NOTE: Several parts of commented out
     *      This is for future design and will be left in until used
     */

    List<MyDataModel> modelList;
    Context context;
    private LayoutInflater mInflater;

    // Constructors
    public MyArrayAdapter(Context context, List<MyDataModel> objects) {
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
            View view = mInflater.inflate(R.layout.layout_stats_view, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        MyDataModel item = getItem(position);

        vh.textViewName.setText(item.getName());
        vh.textViewOffenseStats.setText(item.offenseStats());
        vh.textViewDefenseStats.setText(item.defenseStats());
       // vh.textViewDefenseStats.setText(Html.fromHtml(item.defenseStats()));

//        vh.textViewplayerStats.setText(item.playersStats());
//        vh.textViewCompletions.setText(item.getCompletions());
//        vh.textViewAttempts.setText(item.getAttempts());
//        vh.textViewpassTouchdowns.setText(item.getPassTouchdowns());
//        vh.textViewInterceptions.setText(item.getInterceptions());
//        vh.textViewpassingUnits.setText(item.getPassingUnits());
//        vh.textViewCatches.setText(item.getCatches());
//        vh.textViewreceiveTouchdowns.setText(item.getReceiveTouchdowns());
//        vh.textViewreceiveUnits.setText(item.getReceiveUnits());
//        vh.textViewTackles.setText(item.getTackles());
//        vh.textViewdefInterception.setText(item.getDefInterception());
//        vh.textViewforceFumble.setText(item.getForceFumble());
//        vh.textViewfumbleRecovery.setText(item.getFumbleRecovery());
//        vh.textViewSacks.setText(item.getSacks());
//        vh.textViewDeflections.setText(item.getDeflections());
//        vh.textViewdefTD.setText(item.getDefTD());
//        vh.textViewrushTouchdowns.setText(item.getRushTouchdowns()  );
//        vh.textViewrushUnits.setText(item.getRushUnits());
//        vh.textViewRushes.setText(item.getRushes());
//        vh.textViewfgMade.setText(item.getFgMade());
//        vh.textViewfgTry.setText(item.getFgTry());
//        vh.textViewkickRTD.setText(item.getKickRTD());




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

        public final TextView textViewName;
        public final TextView textViewOffenseStats;
        public final TextView textViewDefenseStats;
//        public final TextView textViewplayerStats;
//        public final TextView textViewAttempts;
//        public final TextView textViewCompletions;
//        public final TextView textViewpassTouchdowns, textViewInterceptions,	textViewpassingUnits;
//        public final TextView textViewCatches, textViewreceiveTouchdowns, textViewreceiveUnits,	textViewTackles, textViewdefInterception, textViewforceFumble;
//        public final TextView textViewfumbleRecovery,	textViewSacks,	textViewDeflections,	textViewdefTD,	textViewrushTouchdowns,	textViewrushUnits;
//        public final TextView textViewRushes,	textViewfgMade,	textViewfgTry,	textViewkickRTD;

//        textViewpassTouchdowns, textViewInterceptions,	textViewpassingUnits, textViewCatches, textViewreceiveTouchdowns, textViewreceiveUnits,	textViewTackles, textViewdefInterception, textViewforceFumble, textViewfumbleRecovery,	textViewSacks,	textViewDeflections,	textViewdefTD,	textViewrushTouchdowns,	textViewrushUnits, textViewRushes,	textViewfgMade,	textViewfgTry,	textViewkickRTD

        private ViewHolder(RelativeLayout rootView, TextView textViewName, TextView textViewOffenseStats, TextView textViewDefenseStats /*TextView textViewplayerStats TextView textViewCompletions, TextView textViewAttempts, TextView textViewpassTouchdowns
            , TextView textViewInterceptions, TextView textViewpassingUnits, TextView textViewCatches, TextView textViewreceiveTouchdowns, TextView textViewreceiveUnits,
                           TextView textViewTackles, TextView textViewdefInterception, TextView textViewforceFumble, TextView textViewfumbleRecovery, TextView textViewSacks
            , TextView textViewDeflections, TextView textViewdefTD, TextView textViewrushTouchdowns, TextView textViewrushUnits, TextView textViewRushes, TextView textViewfgMade
            , TextView textViewfgTry, TextView textViewkickRTD*/) {
            this.rootView = rootView;
            this.textViewName = textViewName;
//            this.textViewplayerStats = textViewplayerStats;
            this.textViewDefenseStats = textViewDefenseStats;
            this.textViewOffenseStats = textViewOffenseStats;
//            this.textViewCompletions = textViewCompletions;
//            this.textViewAttempts = textViewAttempts;
//            this.textViewpassTouchdowns = textViewpassTouchdowns;
//            this.textViewInterceptions = textViewInterceptions;
//            this.textViewpassingUnits = textViewpassingUnits;
//            this.textViewCatches = textViewCatches;
//            this.textViewreceiveTouchdowns = textViewreceiveTouchdowns;
//            this.textViewreceiveUnits = textViewreceiveUnits;
//            this.textViewTackles = textViewTackles;
//            this.textViewdefInterception = textViewdefInterception;
//            this.textViewforceFumble = textViewforceFumble;
//            this.textViewfumbleRecovery = textViewfumbleRecovery;
//            this.textViewSacks = textViewSacks;
//            this.textViewDeflections = textViewDeflections;
//            this.textViewdefTD = textViewdefTD;
//            this.textViewrushTouchdowns = textViewrushTouchdowns;
//            this.textViewrushUnits = textViewrushUnits;
//            this.textViewRushes = textViewRushes;
//            this.textViewfgMade = textViewfgMade;
//            this.textViewfgTry = textViewfgTry;
//            this.textViewkickRTD = textViewkickRTD;

        }

        public static ViewHolder create(RelativeLayout rootView) {
         //   TextView textViewplayerStats = (TextView) rootView.findViewById(R.id.textViewCompletions);
            TextView textViewName = (TextView) rootView.findViewById(R.id.textViewName);
            TextView textViewOffenseStats = (TextView) rootView.findViewById(R.id.textViewOffense);
            TextView textViewDefenseStats = (TextView) rootView.findViewById(R.id.textViewDefense);
//            TextView textViewCompletions = (TextView) rootView.findViewById(R.id.textViewCompletions);
//            TextView textViewAttempts = (TextView) rootView.findViewById(R.id.textViewCompletions);
//            TextView textViewpassTouchdowns = (TextView) rootView.findViewById(R.id.textViewCompletions);
//            TextView textViewInterceptions = (TextView) rootView.findViewById(R.id.textViewCompletions);
//            TextView textViewpassingUnits = (TextView) rootView.findViewById(R.id.textViewCompletions);
//            TextView textViewCatches = (TextView) rootView.findViewById(R.id.textViewCompletions);
//            TextView textViewreceiveTouchdowns = (TextView) rootView.findViewById(R.id.textViewCompletions);
//            TextView textViewreceiveUnits = (TextView) rootView.findViewById(R.id.textViewCompletions);
//            TextView textViewTackles = (TextView) rootView.findViewById(R.id.textViewCompletions);
//            TextView textViewdefInterception = (TextView) rootView.findViewById(R.id.textViewCompletions);
//            TextView textViewforceFumble = (TextView) rootView.findViewById(R.id.textViewCompletions);
//            TextView textViewfumbleRecovery = (TextView) rootView.findViewById(R.id.textViewCompletions);
//            TextView textViewSacks = (TextView) rootView.findViewById(R.id.textViewCompletions);
//            TextView textViewDeflections = (TextView) rootView.findViewById(R.id.textViewCompletions);
//            TextView textViewdefTD = (TextView) rootView.findViewById(R.id.textViewCompletions);
//            TextView textViewrushTouchdowns = (TextView) rootView.findViewById(R.id.textViewCompletions);
//            TextView textViewrushUnits = (TextView) rootView.findViewById(R.id.textViewCompletions);
//            TextView textViewRushes = (TextView) rootView.findViewById(R.id.textViewCompletions);
//            TextView textViewfgMade = (TextView) rootView.findViewById(R.id.textViewCompletions);
//            TextView textViewfgTry = (TextView) rootView.findViewById(R.id.textViewCompletions);
//            TextView textViewkickRTD = (TextView) rootView.findViewById(R.id.textViewCompletions);


            return new ViewHolder(rootView, textViewName, textViewOffenseStats, textViewDefenseStats /*textViewplayerStats,textViewCompletions, textViewAttempts,
                    textViewpassTouchdowns, textViewInterceptions,	textViewpassingUnits,
                    textViewCatches, textViewreceiveTouchdowns, textViewreceiveUnits,
                    textViewTackles, textViewdefInterception, textViewforceFumble,
                    textViewfumbleRecovery,	textViewSacks,	textViewDeflections,
                    textViewdefTD,	textViewrushTouchdowns,	textViewrushUnits,
                    textViewRushes,	textViewfgMade,	textViewfgTry,	textViewkickRTD*/);
        }
    }
}
