package com.example.sedae.myjob;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ActivityilanOlustur extends AppCompatActivity {
    TextView txt;
    private Button ilankaydet;
    private EditText ilan, aciklama;
    private DatabaseReference databaseReference,reference;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityilan_olustur);
        ilankaydet = findViewById(R.id.btn_ilankaydet);
        ilan = findViewById(R.id.etilanAdi);
        aciklama = findViewById(R.id.etilanAciklama);

        databaseReference = FirebaseDatabase.getInstance().getReference("ilanlar");
        reference = FirebaseDatabase.getInstance().getReference("Kullanicilar").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        final Intent intent = new Intent(ActivityilanOlustur.this,Activityilanlarim.class);
        ilankaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addKelime();
                startActivity(intent);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });

        txt= findViewById(R.id.ilanyazisi);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(),"fonts/GrandHotel-Regular.otf");
        txt.setTypeface(myCustomFont);



    }
    private void addKelime(){

            id = reference.getKey();
            String idi = databaseReference.push().getKey();
            if (ilan.getText().length()>0 && aciklama.getText().length()>0){
            Order order = new Order(id,ilan.getText().toString(),aciklama.getText().toString());
            databaseReference.child(idi).setValue(order);
            Toast.makeText(getApplicationContext(), "Yeni İlan Eklendi", Toast.LENGTH_SHORT).show();
            ilan.getText().clear();
            aciklama.getText().clear();
        }
        else {
            Toast.makeText(ActivityilanOlustur.this, "Tüm Alanları Doldur.",Toast.LENGTH_LONG).show();
        }
    }


}
