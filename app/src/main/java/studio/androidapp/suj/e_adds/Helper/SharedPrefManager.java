package studio.androidapp.suj.e_adds.Helper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import studio.androidapp.suj.e_adds.MainActivity.MainActivity;

/**
 * Created by Belal on 9/5/2017.
 */

//here for this class we are using a singleton pattern

public class SharedPrefManager {

    //the constants
    private static final String SHARED_PREF_NAME = "eaddsharedpref";
    private static final String f_NAME = "f_name";
    private static final String l_name = "l_name";
    private static final String email = "email";
    private static final String phone = "phone";
    private static final String location = "location";
    private static final String college = "college";
    private static final String level = "level";
    private static final String field_of_study = "field_of_study";
    private static final String company = "company";
    private static final String post = "post";
    private static final String interest = "interest";
    private static final String id = "id";
    private static final String reg_date = "reg_date";
    private static final String balance = "balance";
    private static final String status = "status";
    private static final String age = "age";
    private static final String sex = "sex";





    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private SharedPrefManager(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    //method to let the user login
    //this method will store the user data in shared preferences
    public void userLogin(User user) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(f_NAME, user.getF_name());
        editor.putString(l_name, user.getL_name());
        editor.putString(email, user.getEmail());
        editor.putString(phone, user.getPhone());
        editor.putString(location, user.getLocation());
        editor.putString(college, user.getCollege());
        editor.putString(level, user.getLevel());
        editor.putString(field_of_study, user.getField_of_study());
        editor.putString(company, user.getCompany());
        editor.putString(post, user.getPost());
        editor.putString(interest, user.getInterest());
        editor.putString(id, user.getId());
        editor.putString(reg_date, user.getReg_date());
        editor.putString(balance, user.getBalance());
        editor.putString(status, user.getStatus());
        editor.putString(age, user.getAge());
        editor.putString(sex, user.getSex());

        editor.apply();
    }

    //this method will checker whether user is already logged in or not
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(f_NAME, null) != null;
    }

    //this method will give the logged in user
    public User getUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(

                sharedPreferences.getString(f_NAME, null),
                sharedPreferences.getString(l_name, null),
                sharedPreferences.getString(email, null),
                sharedPreferences.getString(phone, null),
                sharedPreferences.getString(location, null),
                sharedPreferences.getString(college, null),
                sharedPreferences.getString(level, null),
                sharedPreferences.getString(field_of_study, null),
                sharedPreferences.getString(company, null),
                sharedPreferences.getString(post, null),
                sharedPreferences.getString(interest, null),
                sharedPreferences.getString(id, null),
                sharedPreferences.getString(reg_date, null),
                sharedPreferences.getString(balance, null),
                sharedPreferences.getString(status, null),
                sharedPreferences.getString(age, null),
                sharedPreferences.getString(sex, null)



                );
    }

    //this method will logout the user
    public void logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mCtx.startActivity(new Intent(mCtx, MainActivity.class));
    }
}