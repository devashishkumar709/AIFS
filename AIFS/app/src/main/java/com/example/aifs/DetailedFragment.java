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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class DetailedFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detailed, container, false);
        final TextView title= view.findViewById(R.id.title_det);
        final TextView detial= view.findViewById(R.id.detail);

        DatabaseReference dass;
        dass = FirebaseDatabase.getInstance().getReference();
        dass.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                String v=snapshot.child("Current Card").getValue().toString();
                int v1=Integer.parseInt(v);
                String st_no="Startup"+v;
                //System.out.println(st_no);

                DatabaseReference daa;
                daa = FirebaseDatabase.getInstance().getReference().child(st_no);
                daa.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                        String t=snapshot.child("Title").getValue().toString();
                        String d=snapshot.child("Detailed").getValue().toString();
                        title.setText(t);
                        detial.setText(d);
                    }
                    @Override
                    public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
                    }
                });


            }
            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
            }
        });

        ImageView m416 = (ImageView) view.findViewById(R.id.doggy);
        m416.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.frag,new HomeFragment());
                fr.commit();

            }
        });

        return view;
    }
}