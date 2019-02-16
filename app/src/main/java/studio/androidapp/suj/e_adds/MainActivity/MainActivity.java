package studio.androidapp.suj.e_adds.MainActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import studio.androidapp.suj.e_adds.R;
import studio.androidapp.suj.e_adds.Register.SignUpActivity;
import studio.androidapp.suj.e_adds.Helper.SharedPrefManager;
import studio.androidapp.suj.e_adds.Helper.URL;
import studio.androidapp.suj.e_adds.Helper.User;
import studio.androidapp.suj.e_adds.Helper.VolleySingleton;

public class MainActivity extends AppCompatActivity {

    EditText editTextUsername, editTextPassword;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, dashboard.class));
        }

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        editTextUsername = (EditText) findViewById(R.id.etName);
        editTextPassword = (EditText) findViewById(R.id.etPassword);


        //if user presses on login
        //calling the method login
        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });

        //if user presses on not registered
        findViewById(R.id.tvRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open register screen
                finish();
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
            }
        });
    }

    private void userLogin() {
        //first getting the values
        final String ead_email = editTextUsername.getText().toString();
        final String ead_password = editTextPassword.getText().toString();
        final String ead_token = "ead_nepal_tokan_w345392759";

        //validating inputs
        if (TextUtils.isEmpty(ead_email)) {
            editTextUsername.setError("Please enter your username");
            editTextUsername.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(ead_password)) {
            editTextPassword.setError("Please enter your password");
            editTextPassword.requestFocus();
            return;
        }

        //if everything is fine

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL.LOGIN_URL,
                new Response.Listener<String>() {
                    @Override

                    public void onResponse(String json_response) {
                        //converting response to json object


                        try {
                                JSONObject obj = new JSONObject(json_response);


                                final String abc = obj.getString("status");
                                final String a = obj.getString("status_message");

                          if (a.equalsIgnoreCase("Logged In")) {
                                        Toast.makeText(getApplicationContext(), "successfully logged in", Toast.LENGTH_SHORT).show();




                                //getting the user from the response

                              JSONArray userarray = obj.getJSONArray("data");
                              JSONObject userJson = userarray.getJSONObject(0);
                              final String f_name = userJson.getString("f_name");
                              final String l_name = userJson.getString("l_name");
                              final String email = userJson.getString("email");
                              final String phone = userJson.getString("phone");
                              final String location = userJson.getString("location");
                              final String college = userJson.getString("college");
                              final String level = userJson.getString("level");
                              final String field_of_study = userJson.getString("field_of_study");
                              final String company = userJson.getString("company");
                              final String post = userJson.getString("post");
                              final String interest = userJson.getString("interest");
                              final String id = userJson.getString("id");
                              final String reg_date = userJson.getString("reg_date");
                              final String balance = userJson.getString("balance");
                              final String status = userJson.getString("status");
                              final String age = userJson.getString("age");

                              final String sex = userJson.getString("sex");

                              //creating a new user object
                                User user = new User(f_name, l_name,email,phone,location,college,level,field_of_study,company,post,interest,id,reg_date,balance,status,age,sex);

                                //storing the user in shared preferences
                                SharedPrefManager.getInstance(getApplicationContext()).userLogin(user);

                                //starting the profile activity
                                finish();
                              startActivity(new Intent(getApplicationContext(), dashboard.class));

                            } else {
                                Toast.makeText(getApplicationContext(), a, Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                       // Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(), "Sorry! Please check your internet connection and try again.", Toast.LENGTH_SHORT).show();

                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("ead_token",ead_token);
                params.put("ead_email", ead_email);
                params.put("ead_password", ead_password);
                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }
}
