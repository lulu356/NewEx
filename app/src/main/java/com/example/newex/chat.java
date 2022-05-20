package com.example.newex;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.newex.Adapter.MessAdapterlist;
import com.example.newex.HotelDB.Message;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class chat extends AppCompatActivity {
      private  FirebaseDatabase User;
    private DatabaseReference userDB;
    private DatabaseReference MessDB;
    private EditText messageText;
    private ListView messListView;
    private ArrayList<Message> listMess;
    private MessAdapterlist messAdaper;
    private ConstraintLayout messLayout;
    private FirebaseAuth mAuth;
    private FirebaseUser CurrentUser;
    private int height;
    private String currentUserNick;

    private ValueEventListener commentEventListener;
    private ValueEventListener userValueEventListenerRecipe;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);
        messageText = findViewById(R.id.MessageTXT);
        messLayout = findViewById(R.id.messL);


        messListView = findViewById(R.id.ListMess);
        listMess = new ArrayList<Message>();
        messAdaper = new MessAdapterlist(chat.this, listMess);
        messListView.setAdapter(messAdaper);
        messListView.setClickable(false);


        User = FirebaseDatabase.getInstance("https://newex-eb39a-default-rtdb.firebaseio.com");
        userDB = User.getReference(Constants.USER_KEY);
        MessDB = FirebaseDatabase.getInstance("https://newex-eb39a-default-rtdb.firebaseio.com")
                .getReference(com.example.newex.Constants.COMMENT_KEY);

        mAuth = FirebaseAuth.getInstance();
        CurrentUser = mAuth.getCurrentUser();
        GetCommentFromDB();
    }


    private void GetCommentFromDB() {
        commentEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (listMess.size() > 0) {
                    listMess.clear();
                }
                int i = 1;
                for (DataSnapshot ds : snapshot.getChildren()) {

                    Message message = ds.getValue(Message.class);

                    int height = 500;
                    //Заполняем массив комментариев для этого рецепта

                    assert message != null;
                    listMess.add(message);
                    //Эта чертовщина нужна для изменения размеров ListView комментариев
                    i++;
                    View view = findViewById(R.id.ListMess);
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    height = (height * i * 2);
                    layoutParams.height = height;
                    view.setLayoutParams(layoutParams);

                }
                messAdaper.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        MessDB.addValueEventListener(commentEventListener);
    }

    //Метод отправки комментария
    public void OnClickSendComment(View view) {
        //Проверяем не пустой ли рецепт

        if (!messageText.getText().toString().isEmpty()) {

            //Эта штука нужна для получения времени отправки комментария, оно храниться как String
            Calendar rightNow = Calendar.getInstance();
            // offset to add since we're not UTC
            long offset = rightNow.get(Calendar.ZONE_OFFSET) +
                    rightNow.get(Calendar.DST_OFFSET);
            long sinceMidnight = (rightNow.getTimeInMillis() + offset) %
                    (24 * 60 * 60 * 1000);
            String betweenStr;
            if (rightNow.get(Calendar.MINUTE) < 10) {
                betweenStr = ":0";
            } else {
                betweenStr = ":";
            }

            String DateTime = rightNow.get(Calendar.DATE) + "/" + rightNow.get(Calendar.MONTH) + "/" +
                    rightNow.get(Calendar.YEAR) + " " + rightNow.get(Calendar.HOUR_OF_DAY) + betweenStr + rightNow.get(Calendar.MINUTE);
            Random rnd = new Random();

            //Формируем новый комментарий для отправки его в БД
            //Также формируем для него уникальный ID для того, чтобы можно было его потом удалить
            Message newMess = new Message(MessDB.getKey(),
                    CurrentUser.getUid().hashCode() + "" + "" + sinceMidnight + "" + rnd.nextInt() + "" + rnd.nextInt() + "",
                    DateTime, CurrentUser.getUid().toString(), com.example.newex.Constants.CURRENT_USER_NICK.toString(), messageText.getText().toString());

            //Отправляем его в БД и проверяем отправлен ли он
            MessDB.push().setValue(newMess).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(chat.this, "Коммент отправлен!", Toast.LENGTH_SHORT).show();
                        messageText.setText("");
                    } else {
                        Toast.makeText(chat.this, "Ошибка отправления! Проверьте ваше подключение к сети", Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }
    }
}
