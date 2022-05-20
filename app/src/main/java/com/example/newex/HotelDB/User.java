package com.example.newex.HotelDB;

public class User {
    public  String id, Sname,Name,Fname,Email,Password,Phone,Birthday;

    public User() {
    }
    public User(String id, String Sname,String Name, String Fname,String Email,String Password, String Phone, String Birthday){
        this.id=id;
        this.Sname=Sname;
        this.Name=Name;
        this.Fname=Fname;
        this.Email=Email;
        this.Password=Password;
        this.Phone=Phone;
        this.Birthday=Birthday;
    }
}
