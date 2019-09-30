package com.example.sedae.myjob;

public class Order {



    private String ilanadi;
    private String ilanaciklamasi;
    private String id;

    public Order(){


    }

    public Order(String id, String ilanadi, String ilanaciklamasi) {
        this.ilanadi = ilanadi;
        this.ilanaciklamasi = ilanaciklamasi;
        this.id = id;

    }

    public String getIlanadi() {
        return ilanadi;
    }

    public void setIlanadi(String ilanadi) {
        this.ilanadi = ilanadi;
    }

    public String getIlanaciklamasi() {
        return ilanaciklamasi;
    }

    public void setIlanaciklamasi(String ilanaciklamasi) {
        this.ilanaciklamasi = ilanaciklamasi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
