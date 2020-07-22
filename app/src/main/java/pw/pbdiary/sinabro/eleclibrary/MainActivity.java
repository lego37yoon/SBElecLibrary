package pw.pbdiary.sinabro.eleclibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView mainBottom;
    public static final String firstStore = "null";
    public static final String firstViewer = "null";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainBottom = findViewById(R.id.mainBottomMenu);
        mainBottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mainPrevPage:
                        break;
                    case R.id.mainForwardPage:
                        break;
                    case R.id.mainRefreshEInk:
                        Intent goRefresh = new Intent(getApplicationContext(), eInkRefreshActivity.class);
                        startActivity(goRefresh);
                        break;
                    case R.id.mainNotiMenu:
                        Intent goNotiMenu = new Intent(getApplicationContext(), notiListActivity.class);
                        startActivity(goNotiMenu);
                        break;
                }
                return true;
            }
        });
    }

    public void storeOnClick(View v) {
        SharedPreferences storeFirstSet = getSharedPreferences(firstStore, Context.MODE_PRIVATE);
        if(!storeFirstSet.getBoolean("isStoreSet",false)) {
            SharedPreferences.Editor storeEdit = storeFirstSet.edit();
        }
    }

    public void readerOnClick(View v) {

    }

    public void browserOnClick(View v) {

    }

    public void settingsOnClick(View v) {
        Intent goSettings = new Intent(getApplicationContext(), settingsActivity.class);
        startActivity(goSettings);
    }
}
