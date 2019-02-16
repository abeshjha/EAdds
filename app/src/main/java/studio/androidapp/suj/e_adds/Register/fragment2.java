package studio.androidapp.suj.e_adds.Register;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import studio.androidapp.suj.e_adds.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * } interface
 * to handle interaction events.
 */
public class fragment2 extends Fragment {

    public EditText colleges;
    public EditText companys;
    public EditText posts;
    public Spinner levels;
    public Spinner fieldofstudys;


    public fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_fragment2, container, false);

/*colleges = (EditText)v.findViewById(R.id.college);
companys = (EditText)v.findViewById(R.id.company);
posts= (EditText)v.findViewById(R.id.Post);
levels = (Spinner) v.findViewById(R.id.level);
fieldofstudys=(Spinner)v.findViewById(R.id.fieldofstudy);

final String college = colleges.getText().toString();
        final String company = companys.getText().toString();
        final String post = posts.getText().toString();
        final String level = levels.getSelectedItem().toString();
        final String fieldofstudy = fieldofstudys.getSelectedItem().toString();

        Bundle b = new Bundle();
        b.putString("company",company);
        b.putString("post",post);
        b.putString("level",level);
        b.putString("college",college);
        b.putString("fieldofstudy",fieldofstudy);
//fragment operation
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        Fragment fragment=new fragment3();
        fragment.setArguments(b);
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();*/
        return v;
    }


}
