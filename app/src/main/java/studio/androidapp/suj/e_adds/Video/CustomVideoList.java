package studio.androidapp.suj.e_adds.Video;


import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import studio.androidapp.suj.e_adds.Picture.picture_list;
import studio.androidapp.suj.e_adds.R;

public class CustomVideoList extends BaseAdapter{
    private Activity activity;
    private LayoutInflater inflater;
    private List<picture_list> videoItems;

    public CustomVideoList(Activity activity, List<picture_list> videoItems) {
        this.activity = activity;
        this.videoItems = videoItems;
    }

    @Override
    public int getCount() {
        return videoItems.size();
    }

    @Override
    public Object getItem(int location) {
        return videoItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.video_list, null);

        TextView title = (TextView) convertView.findViewById(R.id.videoname);
        TextView cost = (TextView) convertView.findViewById(R.id.videocost);

        picture_list m = videoItems.get(position);
        title.setText(m.getTitle());

        // release year
        cost.setText("Cost:" + String.valueOf(m.getCost()));
        return convertView;
    }
}
