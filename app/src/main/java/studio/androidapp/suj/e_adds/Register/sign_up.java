package studio.androidapp.suj.e_adds.Register;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import studio.androidapp.suj.e_adds.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class sign_up extends Fragment {



    public sign_up() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_sign_up, container, false);
        EditText  fnames = (EditText)v.findViewById(R.id.fname);
        EditText   lnames = (EditText)v.findViewById(R.id.lname);
        EditText   phones = (EditText)v.findViewById(R.id.phone);
        EditText emails = (EditText)v.findViewById(R.id.email);
        EditText   agess = (EditText)v.findViewById(R.id.age);
        Spinner   districts = (Spinner) v.findViewById(R.id.district);
        final String fname = fnames.getText().toString();
        final String lname = lnames.getText().toString();
        final String phone = phones.getText().toString();
        final String email = emails.getText().toString();
        final String age = agess.getText().toString();
        final String district = districts.getSelectedItem().toString();

        Bundle b = new Bundle();
        b.putString("fname",fname);
        b.putString("lname",lname);
        b.putString("phone",phone);
        b.putString("email",email);
        b.putString("age",age);
        b.putString("district",district);
//fragment operation
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        Fragment fragment=new fragment3();
        fragment.setArguments(b);
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

        return v;
    }

}
