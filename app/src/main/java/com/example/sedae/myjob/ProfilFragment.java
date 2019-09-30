package com.example.sedae.myjob;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfilFragment extends Fragment {

    TextView kuladi,ismi,soyismi,cinsiyeti;
    Button btnLogout;
    Button ilanlarim, ilanver;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference, reference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profil, container,false);

        btnLogout = view.findViewById(R.id.butoncikis);
        kuladi = view.findViewById(R.id.kullanici);
        ismi = view.findViewById(R.id.ismi);
        soyismi = view.findViewById(R.id.soyismi);
        cinsiyeti = view.findViewById(R.id.cinsi);
        ilanlarim = view.findViewById(R.id.btn_ilanlarim);
        ilanver = view.findViewById(R.id.btn_ilanver);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        databaseReference = FirebaseDatabase.getInstance().getReference("Kullanicilar").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        final String aktifkulid = databaseReference.getKey();
        //Toast.makeText(getContext(),aktifkulid,Toast.LENGTH_LONG).show();
        reference = FirebaseDatabase.getInstance().getReference("Kullanicilar");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    Kullanicilar kullanici;
                    final String kullaniciid;
                    kullanici = snapshot.getValue(Kullanicilar.class);
                    kullaniciid = kullanici.getId();

                    if (aktifkulid.equals(kullaniciid)) {
                        kuladi.setText(kullanici.getKullaniciAdi());
                        ismi.setText(kullanici.getKullaniciismi());
                        soyismi.setText(kullanici.getKullanicisoyisim());
                        cinsiyeti.setText(kullanici.getKullanicicinsiyet());
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {}

        });


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getContext(), LoginActivity.class));
            }
        });

        ilanlarim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Activityilanlarim.class));
            }
        });

        ilanver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ActivityilanOlustur.class));
            }
        });




        return view;
    }
}
