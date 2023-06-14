package com.ugb.urban_shop;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity2 extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    FloatingActionButton btnbrujula;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        btnbrujula = findViewById(R.id.btnbrujula);
        btnbrujula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this,"Compass Selected",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), Brujula.class));
            }
        });
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.Open, R.string.Close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                switch (item.getItemId()) {
                    case R.id.home:
                    {
                        Toast.makeText(MainActivity2.this,"Home selected",Toast.LENGTH_LONG).show();
                        break;
                    }

                    case R.id.ropa:
                    {
                        Toast.makeText(MainActivity2.this,"Ropa selected", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        break;
                    }
                    case R.id.cerrar:
                    {
                        Toast.makeText(MainActivity2.this, "Closed session", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), login2.class));
                        break;
                    }

                    case R.id.chat:
                    {
                        Toast.makeText(MainActivity2.this, "Chats selected", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), lista_usuarios.class));
                        break;
                    }

                    case R.id.addp:
                    {
                        Toast.makeText(MainActivity2.this, "Registro selected", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), MainActivity3.class));
                        break;
                    }

                    case R.id.contacto:
                    {
                        //Toast.makeText(MainActivity2.this, "Contacto selected", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), Contacto.class));
                        break;
                    }
                    case R.id.acerca:
                    {
                        //Toast.makeText(MainActivity2.this, "Contacto selected", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), Acerca_de.class));
                        break;
                    }
                }


                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
        super.onBackPressed();
    }
}