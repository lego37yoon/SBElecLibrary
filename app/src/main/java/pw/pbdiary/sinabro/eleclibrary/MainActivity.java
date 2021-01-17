package pw.pbdiary.sinabro.eleclibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
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
            AlertDialog.Builder storeListSel = new AlertDialog.Builder(this);
            storeListSel.setTitle(getResources().getString(R.string.titleStoreList)).setItems(getResources().getStringArray(R.array.storeList), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    switch (i) {
                        case 0:
                            Intent goRidi = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ridibooks.com"));
                            startActivity(goRidi);
                            break;
                        case 1:
                            Intent goYes = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.yes24.com"));
                            startActivity(goYes);
                            break;
                        case 2:
                            Intent goAladin = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aladin.co.kr"));
                            startActivity(goAladin);
                            break;
                        case 3:
                            Intent goKyobo = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.kyobobook.co.kr"));
                            startActivity(goKyobo);
                            break;
                        case 4:
                            Intent goAmazon = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com"));
                            startActivity(goAmazon);
                            break;
                        case 5:
                            Intent goBCube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bookcube.com"));
                            startActivity(goBCube);
                            break;
                        case 6:
                            Intent goIPark = new Intent(Intent.ACTION_VIEW, Uri.parse("http://book.interpark.com"));
                            startActivity(goIPark);
                            break;
                        case 7:
                            Intent goYpBooks = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.readingrak.com"));
                            startActivity(goYpBooks);
                            break;
                        default:
                            break;
                    }
                }
            }).show();

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

    public void selectStore(int i) {

    }
}
