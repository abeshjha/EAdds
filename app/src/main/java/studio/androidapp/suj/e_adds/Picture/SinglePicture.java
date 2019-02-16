package studio.androidapp.suj.e_adds.Picture;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import studio.androidapp.suj.e_adds.Helper.AppController;
import studio.androidapp.suj.e_adds.R;
import studio.androidapp.suj.e_adds.Helper.SharedPrefManager;
import studio.androidapp.suj.e_adds.Helper.URL;
import studio.androidapp.suj.e_adds.Helper.User;

public class SinglePicture extends AppCompatActivity {
    CountDownTimer cTimer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_picture);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ImageLoader imageLoader = AppController.getInstance().getImageLoader();
        Intent i = getIntent();
        final String name = i.getStringExtra("title");
        final String cost = i.getStringExtra("cost");
        final String ead_aid = i.getStringExtra("id");
       final String imagename = i.getStringExtra("image");
        User user = SharedPrefManager.getInstance(this).getUser();
       final String ead_id =  user.getId();
        NetworkImageView picture = (NetworkImageView)findViewById(R.id.image);

        String image = URL.IMAGE+imagename;
        picture.setImageUrl(image,imageLoader);

        TextView title = (TextView)findViewById(R.id.title);
        title.setText("Add Title: "+ name);

        startTimer(cost,ead_aid,ead_id);

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        cancelTimer();

        }
    void startTimer(String cost,String ead_aidd,String ead_idd) {
        final String abc = cost;
        final String ead_token="a";
        final String ead_aid= ead_aidd;
        final String ead_id = ead_idd;
        cTimer = new CountDownTimer(15000, 1000) {
            public void onTick(long millisUntilFinished) {
                TextView time = (TextView)findViewById(R.id.time);
                time.setText("Time Remaining:" + millisUntilFinished / 1000);
            }
            public void onFinish() {
                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL.PHOTOCREDIT_URL,
                        new Response.Listener<String>() {
                            @Override

                            public void onResponse(String json_response) {
                                //converting response to json object


                                try {
                                    JSONObject obj = new JSONObject(json_response);


                                    final String abc = obj.getString("status");
                                    final String a = obj.getString("status_message");
                                    final String data = obj.getString("data");
                                    if (a.equalsIgnoreCase("Logged In")) {
                                        if(data.equalsIgnoreCase("Balance transfered"))

                                        Toast.makeText(getApplicationContext(), data, Toast.LENGTH_SHORT).show();
                                        else{
                                            Toast.makeText(getApplicationContext(), "Already viewed this add", Toast.LENGTH_SHORT).show();

                                        }



                                    } else {
                                        Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();

                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                 Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                               // Toast.makeText(getApplicationContext(), "Sorry! Credit transfer failed. Check your internet connection.", Toast.LENGTH_SHORT).show();

                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("npl_token",ead_token);
                        params.put("npl_aid", ead_aid);
                        params.put("npl_id", ead_id);
                        return params;
                    }
                };

                AppController.getInstance().addToRequestQueue(stringRequest);


            }
        };
        cTimer.start();
    }
    void cancelTimer() {
        if(cTimer!=null)
            cTimer.cancel();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
