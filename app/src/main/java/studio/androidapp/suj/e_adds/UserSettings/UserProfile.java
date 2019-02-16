package studio.androidapp.suj.e_adds.UserSettings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import studio.androidapp.suj.e_adds.R;
import studio.androidapp.suj.e_adds.Helper.SharedPrefManager;
import studio.androidapp.suj.e_adds.Helper.User;

public class UserProfile extends AppCompatActivity {

    private TextView  f_name, l_name,email,phone,location,college,level,field_of_study,comapny,post,interest,id,reg_date,balance,status,age,sex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        f_name = (TextView)findViewById(R.id.fname);
        l_name = (TextView)findViewById(R.id.lname);
        email = (TextView)findViewById(R.id.email);
        phone = (TextView)findViewById(R.id.phone);
        location = (TextView)findViewById(R.id.location);
        college = (TextView)findViewById(R.id.college);
        level = (TextView)findViewById(R.id.level);
        field_of_study = (TextView)findViewById(R.id.fieldofstudy);
        comapny = (TextView)findViewById(R.id.company);
        post = (TextView)findViewById(R.id.Post);
        interest = (TextView)findViewById(R.id.interest);
        id = (TextView)findViewById(R.id.id);
        reg_date = (TextView)findViewById(R.id.reg_date);
        balance = (TextView)findViewById(R.id.balace);
        status = (TextView)findViewById(R.id.status);
        age = (TextView)findViewById(R.id.age);
        sex= (TextView)findViewById(R.id.sex);

        User user = SharedPrefManager.getInstance(this).getUser();

        f_name.setText("first name: "+ user.getF_name());
        l_name.setText("last name: "+user.getL_name());
        email.setText("email: "+user.getEmail());
        phone.setText("phone no: "+user.getPhone());
        location.setText("location: "+user.getLocation());
        college.setText("college: "+user.getCollege());
        level.setText("level: "+user.getLevel());
        field_of_study.setText("field of study: "+user.getField_of_study());
        comapny.setText("company: "+user.getCompany());
        post.setText("post: "+user.getPost());
        interest.setText("interests: "+user.getInterest());
        id.setText("id: "+user.getId());
        reg_date.setText("registered date: "+user.getReg_date());
        balance.setText("your balace: "+user.getBalance());
        status.setText("status: "+user.getStatus());
        age.setText("age: "+user.getAge());
        sex.setText("sex: "+user.getSex());


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
