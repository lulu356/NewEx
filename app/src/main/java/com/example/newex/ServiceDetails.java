package com.example.newex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ServiceDetails extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
            setContentView(R.layout.service_details);
        super.onCreate(savedInstanceState);
    }
    public void back_btn(View view){
        Intent intent= new Intent(this,GlavnMenu.class);
        startActivity(intent);
    }
    public void bookingSer_btn(View view){
        Toast toast= Toast.makeText(this,"Вы забронировали услугу.\n"+"C вами свяжутся наши сотрудники",Toast.LENGTH_LONG);
        toast.show();
        Intent intent= new Intent(this,GlavnMenu.class);
        startActivity(intent);
    }
}
