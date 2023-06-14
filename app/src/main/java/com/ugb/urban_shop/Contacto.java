package com.ugb.urban_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Contacto extends AppCompatActivity  {



    ImageView btnInstagram, btnfacebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        btnInstagram = findViewById(R.id.imgins);
        btnInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://instagram.com/urbanshow2023?igshid=MzNlNGNkZWQ4Mg==");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.instagram.android");

                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {

                    //No encontró la aplicación, abre la versión web.
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://instagram.com/urbanshow2023?igshid=MzNlNGNkZWQ4Mg==")));

                }
            }
        });

        btnfacebook = findViewById(R.id.faceboo);
        btnfacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.facebook.com/profile.php?id=100093693816094&mibextid=ZbWKwL";
                String idF = "https://www.facebook.com/profile.php?id=100093693816094&mibextid=ZbWKwL";
                try {
                    startActivity(new Intent(
                            Intent.ACTION_VIEW, Uri.parse(idF)
                    ));
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(
                            Intent.ACTION_VIEW, Uri.parse(url)
                    ));
                }
            }
        });


    }
}