package com.example.labreportmp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class FragmentMain extends AppCompatActivity {
    ImageButton dotButton;
    SettingsFragment settingsFragment;
    HelpFragment helpFragment;
    FeedbackFragment feedbackFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);
        settingsFragment = new SettingsFragment();
        helpFragment = new HelpFragment();
        feedbackFragment = new FeedbackFragment();
        dotButton = findViewById(R.id.dot_button);
        dotButton.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(FragmentMain.this, v);
            popupMenu.getMenuInflater().inflate(R.menu.option_menu, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    if(item.getItemId() == R.id.option_setting){
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_layout, settingsFragment).commit();
                    }
                    if(item.getItemId() == R.id.option_help){
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_layout, helpFragment).commit();
                    }
                    if(item.getItemId() == R.id.option_feedback){
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_layout, feedbackFragment).commit();
                    }
                    return false;
                }
            });
            popupMenu.show();

        });

    }




}
