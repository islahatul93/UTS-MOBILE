package com.example.mobilelab_uts_33611;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class ListLaguActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lagu);
        getSupportActionBar().setTitle("List Lagu");
        recyclerView = findViewById(R.id.rv);
        getAlert();

        String[] nameSong = {
                "RAVI (라비) – PARADISE (Feat. Ha Sungwoon)", "Ravi – Leaf (낙엽) (Feat. 10cm)",
                "Red Velvet - Future", "가호(Gaho) - Running (스타트업 OST)",
                "가호(Gaho) – Start (시작)", "10cm - Where is Dream",
                "Jung Seung-hwan - Day & Night", "Snowman - Sia",
                "Raiden X CHANYEOL - Yours (Feat. LeeHi, CHANGMO)", "Chani (찬희) - Starlight"
        };

        mainModels = new ArrayList<>();
        for (int i=0;i<nameSong.length;i++) {
            MainModel model = new MainModel(nameSong[i]);
            mainModels.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        mainAdapter = new MainAdapter(ListLaguActivity.this, mainModels);
        recyclerView.setAdapter(mainAdapter);
    }


    private void getAlert() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.layout_popup, null);

        Button OkButton = view.findViewById(R.id.btnOk);

        OkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),"OK",Toast.LENGTH_SHORT);
            }
        });

        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setView(view)
                .create();
        alertDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menuProfil){
            startActivity(new Intent(ListLaguActivity.this, ProfilActivity.class));
        }
        if(id == R.id.menuLogOut){
            startActivity(new Intent(ListLaguActivity.this, MainActivity.class));
        }
        return true;
    }
}