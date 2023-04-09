package com.example.pract.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class MyViewModel extends ViewModel {
    private final String TAG = this.getClass().getSimpleName();

    public void onButtonClick(int item_id) {
        Log.d(TAG, String.valueOf(item_id));
    }
    private final MutableLiveData<Text_Changer> text_changer =
            new MutableLiveData(new Text_Changer(null));

    public LiveData<Text_Changer> getData(){
        return text_changer;
    }

    public void Change_text(String data) {
        text_changer.setValue(new Text_Changer(data));
    }
}