package com.example.sedae.myjob;

public class Kullanicilar {

    public String kullaniciAdi, kullaniciismi, kullanicisoyisim, kullanicicinsiyet, kullanicieposta, kullanicipass,id;

    public Kullanicilar(){


    }

    public Kullanicilar(String id,String kullaniciAdi,String kullaniciismi,String kullanicisoyisim,String kullanicicinsiyet, String kullanicieposta, String kullanicipass){

        this.kullaniciAdi = kullaniciAdi;
        this.kullaniciismi = kullaniciismi;
        this.kullanicisoyisim = kullanicisoyisim;
        this.kullanicicinsiyet = kullanicicinsiyet;
        this.kullanicieposta = kullanicieposta;
        this.kullanicipass = kullanicipass;
        this.id = id;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getKullaniciismi() {
        return kullaniciismi;
    }

    public void setKullaniciismi(String kullaniciismi) {
        this.kullaniciismi = kullaniciismi;
    }

    public String getKullanicisoyisim() {
        return kullanicisoyisim;
    }

    public void setKullanicisoyisim(String kullanicisoyisim) {
        this.kullanicisoyisim = kullanicisoyisim;
    }

    public String getKullanicicinsiyet() {
        return kullanicicinsiyet;
    }

    public void setKullanicicinsiyet(String kullanicicinsiyet) {
        this.kullanicicinsiyet = kullanicicinsiyet;
    }

    public String getKullanicieposta() {
        return kullanicieposta;
    }

    public void setKullanicieposta(String kullanicieposta) {
        this.kullanicieposta = kullanicieposta;
    }

    public String getKullanicipass() {
        return kullanicipass;
    }

    public void setKullanicipass(String kullanicipass) {
        this.kullanicipass = kullanicipass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
