package com.example.newex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newex.HotelDB.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class reg extends AppCompatActivity {
    private EditText email,name,password,Repassword,Sname1,Fname1,birthday,phone;
    private DatabaseReference HotelDB;
    private String User_Key="User";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.reg);
        super.onCreate(savedInstanceState);

        email = findViewById(R.id.Email);
        name= findViewById(R.id.Name);
        password = findViewById(R.id.Password);
        Repassword = findViewById(R.id.rePassword);
        phone= findViewById(R.id.Phone);
        birthday=findViewById(R.id.Birthday);
        Sname1=findViewById(R.id.Sname);
        Fname1=findViewById(R.id.Fname);

        HotelDB= FirebaseDatabase.getInstance().getReference(User_Key);

    }







        public void registration_btn(View view)
        {
            String id = HotelDB.getKey();
            final String Name = name.getText().toString();
            final String Email = email.getText().toString();
            final String Password = password.getText().toString();
            final String repassword = Repassword.getText().toString();
            final String Sname = Sname1.getText().toString();
            final String Fname = Fname1.getText().toString();
            final String Phone = phone.getText().toString();
            final String Birthday = birthday.getText().toString();
            User newUser = new User(id, Sname, Name, Fname, Email, Password, Phone, Birthday);
            HotelDB.push().setValue(newUser);
            if (Name.isEmpty() || Email.isEmpty() || Password.isEmpty() || repassword.isEmpty() || repassword.isEmpty())
            {
                Toast toast = Toast.makeText(reg.this, "Ошибка! Заполните пустые поля", Toast.LENGTH_SHORT);
                toast.show();
            }
            else
            {
                Toast toast = Toast.makeText(reg.this, "Регистрация прошла успешно", Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(reg.this, MainActivity.class);
                startActivity(intent);
            }
        }


}
