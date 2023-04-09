package com.example.pract.view;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pract.R;
import com.example.pract.viewmodel.Activity_List;
import com.example.pract.viewmodel.MyViewModel;

import java.util.ArrayList;

public class SecondFragment extends Fragment {
    private MyViewModel viewModel;
    private final String TAG = this.getClass().getSimpleName();

    private String[] raids_name = new String[]{
            "Root of Noghtmares",
            "King's Fall",
            "Vow of the Disciple",
            "Vault of Glass",
            "Deep Stone Crypt",
            "Garden of Salvation",
            "Last Wish"
    };

    private ListView listView1;
    private Integer[] raid_images = new Integer[]{
            R.drawable.ron,
            R.drawable.king_s_fall_center_4k_0,
            R.drawable.vod,
            R.drawable.vog,
            R.drawable.dsc,
            R.drawable.gos,
            R.drawable.lw,
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);

    }

    @SuppressLint("ResourceType")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        ArrayList<Activity_List> arrayList = new ArrayList<>();
        listView1 = getView().findViewById(R.id.raid_list_view);

        for(int i = 0; i <= 6; i++){
            arrayList.add(new Activity_List(i, raid_images[i],raids_name[i]));
        }


        RaidAdapter raidAdapter = new RaidAdapter(getActivity(), R.layout.design_list_view, arrayList);
        listView1.setAdapter(raidAdapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                viewModel.onButtonClick(arrayList.get(position).getId());
            }
        });
    }



}