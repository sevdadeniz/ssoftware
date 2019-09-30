package com.example.sedae.myjob;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    //TextView kuladi;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container,false);
        setHasOptionsMenu(true);
        recyclerView = view.findViewById(R.id.recylerviewhome);

        //kuladi = view.findViewById(R.id.kullaniciAdi);

        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference myRef = database.getReference();

        //myRef.child("Kullanicilar").addValueEventListener(new ValueEventListener() {
            //@Override
            //public void onDataChange(DataSnapshot dataSnapshot) {
                //for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    //Kullanicilar user = snapshot.getValue(Kullanicilar.class);
                    //kuladi.setText(user.kullaniciAdi);
                //}
            //}
            //@Override
            //public void onCancelled(DatabaseError databaseError) {}

        //});

        //HomeProductAdapter productAdapter = new HomeProductAdapter(getContext(), ProductHome.getData());
        //recyclerView.setAdapter(productAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }

}

