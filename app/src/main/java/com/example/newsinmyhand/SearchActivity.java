package com.example.newsinmyhand;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    EditText searchTerm;
    Button searchBtn;
    TextView searchMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        recyclerView= findViewById(R.id.recycler6);
        searchBtn= findViewById(R.id.search_btn);
        searchTerm= findViewById(R.id.search_term);
        searchMsg= findViewById(R.id.search_msg);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1. Fetch the search term
                String url = "https://newsapi.org/v2/everything?q=" + searchTerm.getText().toString() + "&apiKey=32f70c60fc714320a48dda65beb24d94";
                //2. Create an object of AppData
                AppData appData = new AppData();
                //3. PAss valid arguments
                int numResponse = appData.fetch(url,recyclerView,SearchActivity.this);
                //4. search message
                searchMsg.setText(numResponse+ "search results for "+ searchTerm.getText().toString());
                //4. Clearing the edit text
                searchTerm.setText("");
            }
        });
    }
}