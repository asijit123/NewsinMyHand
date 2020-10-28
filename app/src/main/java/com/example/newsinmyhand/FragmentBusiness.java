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

public class FragmentBusiness extends Fragment {

    RecyclerView recyclerView2;
    String url="https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=32f70c60fc714320a48dda65beb24d94";
    Context context;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_business,container,false);
        recyclerView2= view.findViewById(R.id.recycler2);
        context =getActivity();

        AppData appData = new AppData();

        appData.fetch(url,recyclerView2,context);
        return view;
    }
}
