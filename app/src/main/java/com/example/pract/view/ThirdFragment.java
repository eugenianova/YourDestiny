package com.example.pract.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pract.R;

public class ThirdFragment extends Fragment {

    private static final String TAG = "MyApp";

    private String[] dungeon_names = new String[] {
            "Spire of the Watcher",
            "Duality",
            "Grasp of Avarice",
            "Prophecy",
            "Shattered Throne",
    };

    private int[] dungeons_pics = new int[]{
            R.drawable.sow,
            R.drawable.duality,
            R.drawable.goa,
            R.drawable.prophecy,
            R.drawable.st,
    };

    RecyclerView recyclerView;
    RecyclerView.Adapter progAdapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = this.getArguments();
        TextView textView = getView().findViewById(R.id.textView_dungeon_bundle);
        String result = bundle.getString("data");
        textView.setText(result);

        recyclerView = getView().findViewById(R.id.dungeon_view_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        progAdapter = new ResCustomAdapter(getActivity(), dungeons_pics, dungeon_names);
        recyclerView.setAdapter(progAdapter);
    }
}