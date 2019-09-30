package com.example.sedae.myjob;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Activityilanlarim extends AppCompatActivity {

    DatabaseReference reference,userreference;
    RecyclerView recyclerView;
    ArrayList<Order> list;
    Adapterilanlarim adapterilanlarim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityilanlarim);

        recyclerView = findViewById(R.id.rv_ilanlarim);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<Order>();

        reference = FirebaseDatabase.getInstance().getReference().child("ilanlar");
        userreference = FirebaseDatabase.getInstance().getReference("Kullanicilar").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        final String aktifkulid = userreference.getKey();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                        Order order;
                        final String ilanidbilgisi;
                        order = dataSnapshot1.getValue(Order.class);
                        ilanidbilgisi = order.getId();

                        if (aktifkulid.equals(ilanidbilgisi)) {
                            Order p;
                            p = dataSnapshot1.getValue(Order.class);
                            list.add(p);
                        }
                    }
                    adapterilanlarim = new Adapterilanlarim(Activityilanlarim.this, list);
                    recyclerView.setAdapter(adapterilanlarim);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(Activityilanlarim.this,"Ops",Toast.LENGTH_LONG).show();

            }
        });



    }
}
