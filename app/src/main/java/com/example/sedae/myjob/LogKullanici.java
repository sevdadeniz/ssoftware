package com.example.sedae.myjob;

public class LogKullanici {

    private String Email;
    private String Password;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public LogKullanici (String email, String password){
        this.Email = email;
        this.Password = password;
    }

    public LogKullanici(){

    }
}
