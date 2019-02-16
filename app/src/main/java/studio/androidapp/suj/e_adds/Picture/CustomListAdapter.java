package studio.androidapp.suj.e_adds.Picture;



import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import studio.androidapp.suj.e_adds.Helper.AppController;
import studio.androidapp.suj.e_adds.R;
import studio.androidapp.suj.e_adds.Helper.URL;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<picture_list> pictureItems;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public CustomListAdapter(Activity activity, List<picture_list> pictureItems) {
        this.activity = activity;
        this.pictureItems = pictureItems;
    }

    @Override
    public int getCount() {
        return pictureItems.size();
    }

    @Override
    public Object getItem(int location) {
        return pictureItems.get(location);
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
            convertView = inflater.inflate(R.layout.picture_list, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView cost = (TextView) convertView.findViewById(R.id.cost);


        // getting movie data for the row
        picture_list m = pictureItems.get(position);

        // thumbnail image
        String image = URL.IMAGE+m.getImage();
        thumbNail.setImageUrl(image, imageLoader);

        // title
        title.setText(m.getTitle());

        // rating


        // genre


        // release year
        cost.setText("Cost:" + String.valueOf(m.getCost()));

        return convertView;
    }

}
