package com.firstresources.pimsreport;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.firstresources.pimsreport.contract.FAHarianContract;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Yanuar Diyatmoko
 * @version 1.0.0
 * @date 13/05/2019
 */
public class HomeActivity extends AppCompatActivity implements FAHarianContract.View, NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.btnRptFAHarian)
    Button btnRptFAHarian;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.nav_draw_attend)
    DrawerLayout drawer;
    @BindView(R.id.nav_view) NavigationView navigationView;

//    private SharedPrefManager sharedPrefManager;

    @Override
    public void initViews() {
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.str_open_nav, R.string.str_close_nav);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

//        sharedPrefManager = new SharedPrefManager(this);

        btnRptFAHarian.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

//                sharedPrefManager.saveSPBoolean(Constants.PREFERENCES.EMPLOYEEFINGER, true);
                Intent intentNewFinger = new Intent(getBaseContext(), RptFAHarian.class);
                startActivity(intentNewFinger);
                finish();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        initViews();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.nav_draw_attend);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.logout) {
            startActivity(new Intent(this, StartActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.logout) {
            startActivity(new Intent(this, StartActivity.class));
            return true;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}

