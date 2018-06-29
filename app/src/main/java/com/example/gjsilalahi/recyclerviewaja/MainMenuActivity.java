package com.example.gjsilalahi.recyclerviewaja;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import static android.widget.Toast.LENGTH_SHORT;

public class MainMenuActivity extends AppCompatActivity {

    VideoView videoView;
    CardView cardView1, cardView2, cardView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toast.makeText(getApplicationContext(), "Selamat Datang", LENGTH_SHORT).show();

        videoView = findViewById(R.id.vvIndo);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vindo));
        videoView.setMediaController(new MediaController(this));
        videoView.start();

        cardView1 = findViewById(R.id.cvIsi);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        cardView2 = findViewById(R.id.cvInfo);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MEMBUAT DIALOG MESSAGE
                AlertDialog.Builder builder = new AlertDialog.Builder(MainMenuActivity.this);
                builder.setTitle("INFO APLIKASI");
                builder.setMessage(R.string.app_info);
                builder.setPositiveButton("OKE BOY", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        cardView3 = findViewById(R.id.cvKeluar);
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainMenuActivity.this);
                builder.setTitle("Anda yakin ingin keluar ?");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog quit = builder.create();
                quit.show();
            }
        });

    }
}
