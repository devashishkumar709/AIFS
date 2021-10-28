package com.example.aifs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class HomeFragment extends Fragment {
    String rating11;
    String rating22;
    String rating33;
    String rating44;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView title1= view.findViewById(R.id.title1);
        final TextView type1 = (TextView) view.findViewById(R.id.type1);
        final TextView breif1 = (TextView) view.findViewById(R.id.breif1);
        final TextView rating1 = (TextView) view.findViewById(R.id.rating1);

        final TextView title2= view.findViewById(R.id.title2);
        final TextView type2 = (TextView) view.findViewById(R.id.type2);
        final TextView breif2 = (TextView) view.findViewById(R.id.breif2);
        final TextView rating2 = (TextView) view.findViewById(R.id.rating2);

        final TextView title3= view.findViewById(R.id.title3);
        final TextView type3 = (TextView) view.findViewById(R.id.type3);
        final TextView breif3 = (TextView) view.findViewById(R.id.breif3);
        final TextView rating3 = (TextView) view.findViewById(R.id.rating3);

        final TextView title4= view.findViewById(R.id.title4);
        final TextView type4 = (TextView) view.findViewById(R.id.type4);
        final TextView breif4 = (TextView) view.findViewById(R.id.breif4);
        final TextView rating4 = (TextView) view.findViewById(R.id.rating4);

        // card view1
        DatabaseReference dass;
        dass = FirebaseDatabase.getInstance().getReference().child("Startup1");
        dass.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                String title11=snapshot.child("Title").getValue().toString();
                String type11=snapshot.child("Type").getValue().toString();
                String breif11=snapshot.child("Brief").getValue().toString();
                rating11=snapshot.child("Rating").getValue().toString();
                title1.setText(title11);
                type1.setText(type11);
                breif1.setText(breif11);
                rating1.setText(rating11+"/10");
            }
            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
            }
        });

        final EditText user_rating1 = (EditText) view.findViewById(R.id.user_rate1);
        ImageView sync1 =(ImageView) view.findViewById(R.id.conf1);
        sync1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_rating11 = user_rating1.getText().toString().trim();
                int ur1=Integer.parseInt(user_rating11);
                if(ur1>=0 && ur1<=10){
                    int or1=Integer.parseInt(rating11);
                    int nr1=(ur1+or1)/2;
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("Startup1");
                    myRef.child("Rating").setValue(nr1);
                }
                else{
                    Toast toast =  Toast.makeText(getActivity(), "Rating must be between 0 to 10", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL| Gravity.CENTER,0 ,350);
                    toast.show();

                }




            }
        });

        //CardView2
        DatabaseReference dass2;
        dass2 = FirebaseDatabase.getInstance().getReference().child("Startup2");
        //System.out.println("out");
        dass2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                //System.out.println("in");
                String title22=snapshot.child("Title").getValue().toString();
                //System.out.println(title22);
                String type22=snapshot.child("Type").getValue().toString();
                String breif22=snapshot.child("Brief").getValue().toString();
                rating22=snapshot.child("Rating").getValue().toString();
                title2.setText(title22);
                type2.setText(type22);
                breif2.setText(breif22);
                rating2.setText(rating22+"/10");
            }
            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
            }
        });

        final EditText user_rating2 = (EditText) view.findViewById(R.id.user_rate2);
        ImageView sync2 =(ImageView) view.findViewById(R.id.conf2);
        sync2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_rating22 = user_rating2.getText().toString().trim();
                //System.out.println(rating11);
                int ur2=Integer.parseInt(user_rating22);
                if(ur2>=0 && ur2<=10){
                    int or2=Integer.parseInt(rating22);
                    int nr2=(ur2+or2)/2;
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("Startup2");
                    myRef.child("Rating").setValue(nr2);
                }
                else {
                    Toast toast = Toast.makeText(getActivity(), "Rating must be between 0 to 10", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER, 0, 350);
                    toast.show();
                }

            }
        });

        //CardView3
        DatabaseReference dass3;
        dass3 = FirebaseDatabase.getInstance().getReference().child("Startup3");
        dass3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                //System.out.println("in");
                String title33=snapshot.child("Title").getValue().toString();
                //System.out.println(title22);
                String type33=snapshot.child("Type").getValue().toString();
                String breif33=snapshot.child("Brief").getValue().toString();
                rating33=snapshot.child("Rating").getValue().toString();
                title3.setText(title33);
                type3.setText(type33);
                breif3.setText(breif33);
                rating3.setText(rating33+"/10");
            }
            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
            }
        });

        final EditText user_rating3 = (EditText) view.findViewById(R.id.user_rate3);
        ImageView sync3 =(ImageView) view.findViewById(R.id.conf3);
        sync3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_rating33 = user_rating3.getText().toString().trim();
                //System.out.println(rating11);
                int ur3=Integer.parseInt(user_rating33);
                if(ur3>=0 && ur3<=10){
                    int or3=Integer.parseInt(rating33);
                    int nr3=(ur3+or3)/2;
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("Startup3");
                    myRef.child("Rating").setValue(nr3);
                }
                else {
                    Toast toast = Toast.makeText(getActivity(), "Rating must be between 0 to 10", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER, 0, 350);
                    toast.show();
                }

            }
        });

        //CardView4
        DatabaseReference dass4;
        dass4 = FirebaseDatabase.getInstance().getReference().child("Startup4");
        dass4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                //System.out.println("in");
                String title44=snapshot.child("Title").getValue().toString();
                //System.out.println(title22);
                String type44=snapshot.child("Type").getValue().toString();
                String breif44=snapshot.child("Brief").getValue().toString();
                rating44=snapshot.child("Rating").getValue().toString();
                title4.setText(title44);
                type4.setText(type44);
                breif4.setText(breif44);
                rating4.setText(rating44+"/10");
            }
            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
            }
        });

        final EditText user_rating4 = (EditText) view.findViewById(R.id.user_rate4);
        ImageView sync4 =(ImageView) view.findViewById(R.id.conf4);
        sync4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_rating44 = user_rating4.getText().toString().trim();
                //System.out.println(rating11);
                int ur4=Integer.parseInt(user_rating44);
                if(ur4>=0 && ur4<=10){
                    int or4=Integer.parseInt(rating44);
                    int nr4=(ur4+or4)/2;
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("Startup4");
                    myRef.child("Rating").setValue(nr4);
                }
                else {
                    Toast toast = Toast.makeText(getActivity(), "Rating must be between 0 to 10", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER, 0, 350);
                    toast.show();
                }

            }
        });


        TextView m1 = (TextView) view.findViewById(R.id.more1);
        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Current Card");
                myRef.setValue("1");
                FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.frag,new DetailedFragment());
                fr.commit();

            }
        });
        TextView m2 = (TextView) view.findViewById(R.id.more2);
        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Current Card");
                myRef.setValue("2");
                FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.frag,new DetailedFragment());
                fr.commit();

            }
        });
        TextView m3 = (TextView) view.findViewById(R.id.more3);
        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Current Card");
                myRef.setValue("3");
                FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.frag,new DetailedFragment());
                fr.commit();

            }
        });
        TextView m4 = (TextView) view.findViewById(R.id.more4);
        m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Current Card");
                myRef.setValue("4");
                FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.frag,new DetailedFragment());
                fr.commit();

            }
        });

        return view;
    }
}