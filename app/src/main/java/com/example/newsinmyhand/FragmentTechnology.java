package com.example.newsinmyhand;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentTechnology extends Fragment {
    RecyclerView recyclerView3;
    String url="https://newsapi.org/v2/top-headlines?country=in&category=technology&apiKey=32f70c60fc714320a48dda65beb24d94";
    Context context;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_technology,container,false);
        recyclerView3= view.findViewById(R.id.recycler3);
        context =getActivity();

        AppData appData = new AppData();

        appData.fetch(url,recyclerView3,context);
        return view;
    }
}
