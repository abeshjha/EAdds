package studio.androidapp.suj.e_adds.Register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import studio.androidapp.suj.e_adds.MainActivity.MainActivity;
import studio.androidapp.suj.e_adds.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class fragment3 extends Fragment {
    private Button register;

    public fragment3() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle b = getArguments();
      final String fname=  b.getString("fname");
        final String lname = b.getString("lname");
        final  String phone  =b.getString("phone");
        final String email  =b.getString("email");
        final String age  = b.getString("age");
        final String district = b.getString("district");
        final String company  = b.getString("company");
        final String post   =b.getString("post");
        final String level   = b.getString("level");
        final String college   = b.getString("college");
        final String fieldofstudy =  b.getString("fieldofstudy");
        View v = inflater.inflate(R.layout.fragment_fragment3, container, false);

        register = (Button)v.findViewById(R.id.btnregister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "anm", Toast.LENGTH_SHORT).show();
            }
        });
        Intent i = new Intent(v.getContext(),MainActivity.class);
        startActivity(i);
        return v;
    }


}
