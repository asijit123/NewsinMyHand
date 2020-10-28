package com.example.newsinmyhand;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BookmarkActivity extends AppCompatActivity {

    RecyclerView recyclerView7;
    String userId;
    FirebaseDatabase database;
    DatabaseReference myRef;
    AppData appData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        recyclerView7=findViewById(R.id.recycler7);
        userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        database =FirebaseDatabase.getInstance();
        myRef =database.getReference("users/"+ userId);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               appData =new AppData();
               appData.fetchFromFirebase(dataSnapshot,BookmarkActivity.this,recyclerView7);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(BookmarkActivity.this, "Some error occured", Toast.LENGTH_SHORT).show();
            }
        });
    }
}