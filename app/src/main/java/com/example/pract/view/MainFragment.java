package com.example.pract.view;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pract.R;
import com.example.pract.viewmodel.MyViewModel;
import com.example.pract.viewmodel.Text_Changer;

public class MainFragment extends Fragment {
    private final String TAG = this.getClass().getSimpleName();
    private NotificationManager notificationManager;
    private static final int NOTIFY_ID = 1;
    private static final String CHANNEL_ID="CHANNEl_ID";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        Toast.makeText(getContext(), "onViewCreated", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onViewCreated");
        notificationManager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);

        Button raid_button = getView().findViewById(R.id.raidButton);
        raid_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg) {
                Log.i(TAG, "Переход к списку рейдов");
                Navigation.findNavController(arg).navigate(R.id.action_FirstFragment_to_SecondFragment);
            }

        });

        Button dungeonButton = getView().findViewById(R.id.dungeonButton);
        dungeonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg) {
                Bundle bundle = new Bundle();
                String data_dungeon = "Count of dungeons - 100";
                bundle.putString("data", data_dungeon);
                Navigation.findNavController(arg).navigate(R.id.action_FirstFragment_to_ThirdFragment,
                        bundle);

            }

        });
        EditText editText = getView().findViewById(R.id.editTextTextPersonName);

        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        viewModel.getData().observe(getViewLifecycleOwner(), text_changer -> {
            String changed_text = text_changer.getEdited_text();
            System.out.println(changed_text);
        });

        Button button3 = getView().findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg) {
                Log.i(TAG, "Кнопка поиска");
                viewModel.Change_text(editText.getText().toString());
            }

        });

    }
    private void showNotification() {
        NotificationCompat.Builder builder = new
                NotificationCompat.Builder(getContext(), CHANNEL_ID)
                .setAutoCancel(false)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(getString(
                        R.string.nothing_search))
                .setContentText("Вы ничего не ввели....")
                .setPriority(NotificationCompat.PRIORITY_HIGH);
        createChannelIfNeeded(notificationManager);
        notificationManager.notify(NOTIFY_ID, builder.build());
    }

    public static void  createChannelIfNeeded(NotificationManager manager){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(notificationChannel);
        }
    }

}