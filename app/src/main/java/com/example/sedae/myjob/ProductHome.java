package com.example.sedae.myjob;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;



public class ProductHome {

    private String kullaniciAdi;
    private String ilanAciklama;
    private String ilanAdi;
    private int imageID;
    private int setImage;
    private int kullaniciImage;
    private int likeButon;
    private int messageButton;

    public ProductHome() {
    }

    public ProductHome(int imageID, int kullaniciImage, int setImage, int likeButon, int messageButton, String kullaniciAdi, String ilanAdi, String ilanAciklama) {
        this.imageID = imageID;
        this.kullaniciImage = kullaniciImage;
        this.kullaniciAdi = kullaniciAdi;
        this.ilanAciklama = ilanAciklama;
        this.setImage = setImage;
        this.likeButon = likeButon;
        this.ilanAdi = ilanAdi;
        this.messageButton = messageButton;
    }


    public int getKullaniciImage() {
        return kullaniciImage;
    }

    public void setKullaniciImage(int kullaniciImage) {
        this.kullaniciImage = kullaniciImage;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public int getSetImage() {
        return setImage;
    }

    public void setSetImage(int setImage) {
        this.setImage = setImage;
    }

    public String getIlanAdi() {
        return ilanAdi;
    }

    public void setIlanAdi(String ilanAdi) {
        this.ilanAdi = ilanAdi;
    }

    public String getIlanAciklama() {
        return ilanAciklama;
    }

    public void setIlanAciklama(String productDescription) {
        this.ilanAciklama = productDescription;
    }

    public int getLikeButon() {
        return likeButon;
    }

    public void setLikeButon(int likeButon) {
        this.likeButon = likeButon;
    }

    public int getMessageButton() {
        return messageButton;
    }

    public void setMessageButton(int messageButton) {
        this.messageButton = messageButton;
    }


    //public static ArrayList<ProductHome> getData() {
        //ArrayList<ProductHome> productList = new ArrayList<ProductHome>();
        //int kullaniciImages[] = {R.drawable.user, R.drawable.user, R.drawable.user};
        //int setImages[] = {R.drawable.sikayet, R.drawable.sikayet, R.drawable.sikayet};
        //int likeButon[] = {R.drawable.favorite_bos, R.drawable.favorite_bos, R.drawable.favorite_bos};
        //int messageButon[] = {R.drawable.message, R.drawable.message, R.drawable.message};
        //final String[] kullaniciAdi = {"KullanıcıAdi", "Kulanıcı Adı", "Kullanıcı"};
        //String[] ilanAciklama = {"Ayrıntdfdfdsgfgfı", "AYrıntghghhghjhjfhı","Ayrıntıfdhdgjghjhjgh"};
        //String[] ilanAdi = {"Kuryecilik", "Pizzacilik","Temizlik"};

        //for (int i = 0; i < kullaniciImages.length; i++) {
            //ProductHome temp = new ProductHome();
            //temp.setImageID(kullaniciImages[i]);
            //temp.setKullaniciAdi(kullaniciAdi[i]);
            //temp.setSetImage(setImages[i]);
            //temp.setIlanAdi(ilanAdi[i]);
            //temp.setIlanAciklama(ilanAciklama[i]);
            //temp.setLikeButon(likeButon[i]);
            //temp.setMessageButton(messageButon[i]);

            //productList.add(temp);

        //}


        //return productList;


    //}
}
