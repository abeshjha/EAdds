package studio.androidapp.suj.e_adds.Audio;


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

public class CustomAudioList extends BaseAdapter{
    private Activity activity;
    private LayoutInflater inflater;
    private List<picture_list> audioItems;

    public CustomAudioList(Activity activity, List<picture_list> audioItems) {
        this.activity = activity;
        this.audioItems = audioItems;
    }

    @Override
    public int getCount() {
        return audioItems.size();
    }

    @Override
    public Object getItem(int location) {
        return audioItems.get(location);
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
            convertView = inflater.inflate(R.layout.audio_list, null);

        TextView title = (TextView) convertView.findViewById(R.id.audioname);
        TextView cost = (TextView) convertView.findViewById(R.id.audiocost);

        picture_list m = audioItems.get(position);
        title.setText(m.getTitle());

        // release year
        cost.setText("Cost:" + String.valueOf(m.getCost()));
        return convertView;
    }
}
