package com.example.newex;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class roomdetails extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.new_roomdetails);
        super.onCreate(savedInstanceState);
       TextView text=findViewById(R.id.descriptionTxt);

    }

    public void back_btn(View view){
        Intent intent= new Intent(roomdetails.this,GlavnMenu.class);
        startActivity(intent);
    }
    public void booking_btn(View view){
       // Toast toast= Toast.makeText(this,"Вы забронировали номер.\n"+"C вами свяжутся наши сотрудники",Toast.LENGTH_LONG);
       // toast.show();
        Intent intent= new Intent(this,chat.class);
        startActivity(intent);
    }
}
