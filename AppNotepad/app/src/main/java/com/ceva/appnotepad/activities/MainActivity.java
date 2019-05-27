package com.ceva.appnotepad.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.ceva.appnotepad.R;
import com.ceva.appnotepad.fragments.MainFragment;
import com.ceva.appnotepad.fragments.PendientesFragment;
import com.ceva.appnotepad.fragments.SuperMercadoFragment;
import com.ceva.appnotepad.fragments.VacacionesFragment;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    //FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = (NavigationView)findViewById(R.id.navigationView);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        //fab = (FloatingActionButton)findViewById(R.id.fab);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.isChecked())
                {
                    menuItem.setChecked(false);
                }
                else
                {
                    menuItem.setChecked(true);
                }
                drawerLayout.closeDrawers();

                //identificamos el item seleccionado del menu
                switch(menuItem.getItemId())
                {
                    case R.id.principal:
                        setFragment(0);
                        break;
                    case R.id.supermercado:
                        setFragment(1);
                        break;
                    case R.id.pendientes:
                        setFragment(2);
                        break;
                    case R.id.vacaciones:
                        setFragment(3);
                        break;
                }

                return false;
            }
        });

        ActionBarDrawerToggle actionBarDrawerToggle =
                new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.open, R.string.close)
                {
                    @Override
                    public void onDrawerOpened(View drawerView) {
                        super.onDrawerOpened(drawerView);
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        super.onDrawerClosed(drawerView);
                    }
                };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        setFragment(0);
    }

    public void setFragment(int pos)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        switch(pos)
        {
            case 0:
                MainFragment fragment = new MainFragment();
                transaction.replace(R.id.fragment, fragment);
                transaction.commit();
                break;
            case 1:
                SuperMercadoFragment fragmentSupermercado = new SuperMercadoFragment();
                transaction.replace(R.id.fragment, fragmentSupermercado);
                transaction.commit();
                break;
            case 2:
                PendientesFragment fragmentPendientes = new PendientesFragment();
                transaction.replace(R.id.fragment, fragmentPendientes);
                transaction.commit();
                break;
            case 3:
                VacacionesFragment fragmentVacaciones = new VacacionesFragment();
                transaction.replace(R.id.fragment, fragmentVacaciones);
                transaction.commit();
                break;
        }
        /**
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "FAB", Toast.LENGTH_SHORT).show();
            }
        });
         **/
    }
}
