package com.example.aifs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AtsFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ats, container, false);
        final EditText title_title = (EditText) view.findViewById(R.id.in_title);
        final EditText type_type = (EditText) view.findViewById(R.id.in_type);
        final EditText brief_brief = (EditText) view.findViewById(R.id.in_brief);
        final EditText detail_detail = (EditText) view.findViewById(R.id.in_detail);

        ImageView savvvv = (ImageView) view.findViewById(R.id.save_save);
        savvvv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tt = title_title.getText().toString().trim();
                String tty = type_type.getText().toString().trim();
                String bb = brief_brief.getText().toString().trim();
                String dd = detail_detail.getText().toString().trim();

                if(tt.isEmpty() || tty.isEmpty() || bb.isEmpty() || dd.isEmpty()){
                    Toast toast =  Toast.makeText(getActivity(), "Enter All Fields", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL| Gravity.CENTER,0 ,350);
                    toast.show();
                }
                else{
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("Startup5");
                    myRef.child("Title").setValue(tt);
                    myRef.child("Type").setValue(tty);
                    myRef.child("Brief").setValue(bb);
                    myRef.child("Detailed").setValue(dd);


                }
            }
        });


        return view;
    }
}