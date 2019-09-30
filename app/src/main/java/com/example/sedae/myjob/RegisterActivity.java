package com.example.sedae.myjob;

import android.content.Intent;
import android.graphics.Typeface;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity{
    TextView t1,t2;
    EditText Isim, Soyisim, Kullaniciadi, Mail, Sifre, Sifreyeniden;
    RadioButton Cins;
    RadioGroup Cinsiyetgrup;
    Button Kaydol;
    FirebaseAuth firebaseAuth;
    String Cinsiyet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Şekilli yazı için aşagıdaki üç satır yazıldı.
        t1 = findViewById(R.id.kaydol_yazi2);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/GrandHotel-Regular.otf");
        t1.setTypeface(myCustomFont);

        TextView textView = findViewById(R.id.girisyap);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();

        Isim = findViewById(R.id.isim);
        Soyisim = findViewById(R.id.soyisim);
        Kullaniciadi = findViewById(R.id.kullaniciadi);
        Mail = findViewById(R.id.email);
        Sifre = findViewById(R.id.sifre);
        Sifreyeniden = findViewById(R.id.sifreyeniden);
        Cinsiyetgrup = findViewById(R.id.cinsiyet);
        Kaydol = findViewById(R.id.kaydol);



        Kaydol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Isim.getText().toString().trim();
                    Soyisim.getText().toString().trim();
                    Kullaniciadi.getText().toString().trim();
                    Sifre.getText().toString().trim();
                    Sifreyeniden.getText().toString().trim();

                    int selectedId = Cinsiyetgrup.getCheckedRadioButtonId();
                    Cins = findViewById(selectedId);

                    if (!Isim.getText().toString().equals("") && !Soyisim.getText().toString().equals("") &&
                            !Kullaniciadi.getText().toString().equals("") && !Sifre.getText().toString().equals("") &&
                            !Sifreyeniden.getText().toString().equals("")) {

                        if (Sifre.getText().toString().equals(Sifreyeniden.getText().toString())) {

                            if (Cins.getText().equals("Kadın"))
                                Cinsiyet = "Kadın";
                            else
                                Cinsiyet = "Erkek";

                                firebaseAuth.createUserWithEmailAndPassword(Mail.getText().toString().trim(), Sifre.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {

                                        if (task.isSuccessful()) {
                                            Toast.makeText(RegisterActivity.this, "Kayıt İşlemi Başarılı", Toast.LENGTH_LONG).show();
                                            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Kullanicilar");
                                            String id = databaseReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).getKey(); //oluşan id String id kaydediliyor
                                            Kullanicilar kullanicilar = new Kullanicilar(
                                                    id,
                                                    Kullaniciadi.getText().toString().trim(),
                                                    Isim.getText().toString().trim(),
                                                    Soyisim.getText().toString().trim(),
                                                    Cinsiyet,
                                                    Mail.getText().toString().trim(),
                                                    Sifre.getText().toString().trim()

                                            );

                                            FirebaseDatabase.getInstance().getReference("Kullanicilar")
                                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(kullanicilar).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()) {
                                                        Toast.makeText(RegisterActivity.this, "Kullanıcı Bilgileri Kaydedildi", Toast.LENGTH_LONG).show();

                                                    }
                                                }
                                            });

                                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

                                        } else {
                                            Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                            Isim.getText().clear();
                                            Soyisim.getText().clear();
                                            Kullaniciadi.getText().clear();
                                            Mail.getText().clear();
                                            Sifre.getText().clear();
                                            Sifreyeniden.getText().clear();
                                        }
                                    }
                                });
                    } else {
                        Toast.makeText(RegisterActivity.this, "Şifreler Aynı Değil", Toast.LENGTH_LONG).show();
                            Sifre.getText().clear();
                            Sifreyeniden.getText().clear();}
                }else{
                        Toast.makeText(RegisterActivity.this, "Lütfen Zorunlu Alanları Doldurun.", Toast.LENGTH_LONG).show(); }
            }
        });
    }
}




