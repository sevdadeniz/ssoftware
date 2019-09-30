package com.example.sedae.myjob;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FavPoductAdapter extends RecyclerView.Adapter<FavPoductAdapter.MyViewHolder> {

    static ArrayList<ProductFavori> mProductList;
    LayoutInflater inflater;

    public FavPoductAdapter(Context context, ArrayList<ProductFavori> products) {
        inflater = LayoutInflater.from(context);
        this.mProductList = products;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_product_card, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ProductFavori selectedProduct = mProductList.get(position);
        holder.setData(selectedProduct, position);

    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView kullaniciAdi, ilanAdi, ilanAciklama;
        ImageView profilImage, setImage;
        ImageButton messageButon, favoriButon;

        public MyViewHolder(View itemView) {
            super(itemView);
            kullaniciAdi =  itemView.findViewById(R.id.kullaniciAdi);
            ilanAdi = itemView.findViewById(R.id.ilanAdi);
            ilanAciklama = itemView.findViewById(R.id.ilanAciklama);
            setImage = itemView.findViewById(R.id.setImage);
            profilImage =  itemView.findViewById(R.id.profilImage);
            messageButon = itemView.findViewById(R.id.messageButton);
            favoriButon = itemView.findViewById(R.id.likeButon);
            setImage.setOnClickListener(this);

        }

        public void setData(ProductFavori selectedProduct, int position) {

            this.kullaniciAdi.setText(selectedProduct.getKullaniciAdi());
            this.ilanAdi.setText(selectedProduct.getIlanAdi());
            this.setImage.setImageResource(selectedProduct.getSetImage());
            this.profilImage.setImageResource(selectedProduct.getKullaniciImage());
            this.ilanAciklama.setText(selectedProduct.getIlanAciklama());
            this.messageButon.setImageResource(selectedProduct.getMessageButton());
            this.favoriButon.setImageResource(selectedProduct.getLikeButon());
        }


        @Override
        public void onClick(View v) {


        }


    }
}
