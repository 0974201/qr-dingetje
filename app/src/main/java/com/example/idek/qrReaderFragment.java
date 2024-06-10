package com.example.idek;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class qrReaderFragment extends AppCompatActivity {

    private TextView textDing;
    private Button knopje;
    String txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_qr_reader);

        this.textDing = findViewById(R.id.textDing);
        this.knopje = findViewById(R.id.knopj);
        knopje.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentTransaction ts = getSupportFragmentManager().beginTransaction(); //switch naar de camera
                ts.replace(R.id.qrReaderContainer, new CameraFragment());
                ts.addToBackStack(null);
                ts.commit();
                //FragmentManager fm = getSupportFragmentManager();
                //FragmentTransaction ft = fm.beginTransaction();
                //ft.replace(R.id.qrReaderContainer, new CameraFragment());
                //ft.addToBackStack(null);
                //ft.commit();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) { //verwerkt wat er uit de scanding is gekomen
        super.onActivityResult(requestCode, resultCode, data);
        //Bundle bun = new Bundle();
        //bun.getBundle("message");

        //textDing.setText(bun.getString("message"));

        if (requestCode == 1) {
            if (requestCode == RESULT_OK) {
                if (data.hasExtra("res")) {
                    txt = data.getExtras().toString();
                    textDing.setText(txt);
                    Log.wtf(String.valueOf(this), "scanned.");
                } else {
                    Log.wtf(String.valueOf(this), "phail");
                }
            } else {
                System.out.println("u done goofed.");
            }
        }
    }

}