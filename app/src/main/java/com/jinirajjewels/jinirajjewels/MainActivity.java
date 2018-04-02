package com.jinirajjewels.jinirajjewels;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    static final int REQUEST_PERMISSION_KEY = 1;
    private static final Integer[] XMEN = {R.drawable.ring1, R.drawable.bangles1, R.drawable.earring3, R.drawable.mangalsutra1, R.drawable.necklace1, R.drawable.pendant3};
    String[] text = {"Rings", "Bangles", "Earrings", "Mangalsutra", "Necklace", "Pendant"};
    int[] ImageId = {R.drawable.rings, R.drawable.bangles, R.drawable.earrings, R.drawable.mangalsutra2, R.drawable.necklace1, R.drawable.pendant3};

    private static ViewPager mPager;
    private static DotsIndicator  dotsIndicator;
    private static int currentPage = 0;
    GridView grid;




    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SimpleImageListAdapter adapter = new SimpleImageListAdapter(MainActivity.this, ImageId, text);
        grid=(GridView)findViewById(R.id.usage_example_gridview);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position) {
                    case 0:

                        Intent i = new Intent(getApplicationContext(), Rings.class);
                        i.putExtra("id", position);
                        startActivity(i);
                        break;

                    case 1:
                        //Use some different intent here
                        Intent j = new Intent(getApplicationContext(), Bangles.class);
                        j.putExtra("id", position);
                        startActivity(j);
                        break;
                    case 2:
                        //Use some different intent here
                        Intent k = new Intent(getApplicationContext(), Earrings.class);
                        k.putExtra("id", position);
                        startActivity(k);
                        break;
                    case 3:
                        //Use some different intent here
                        Intent l = new Intent(getApplicationContext(), Mangalsutra.class);
                        l.putExtra("id", position);
                        startActivity(l);
                        break;
                    case 4:
                        //Use some different intent here
                        Intent m = new Intent(getApplicationContext(), Necklace.class);
                        m.putExtra("id", position);
                        startActivity(m);
                        break;
                    case 5:
                        //Use some different intent here
                        Intent n = new Intent(getApplicationContext(),Pendant.class);
                        n.putExtra("id", position);
                        startActivity(n);
                        break;

                    default:
                        break;
                }



            }
        });



        init();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }


    private void init() {
        for (int i = 0; i < XMEN.length; i++)
            XMENArray.add(XMEN[i]);


        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyAdapter(MainActivity.this, XMENArray));


        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == XMEN.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_gallery) {
            Intent i = new Intent(this, BuyNow.class);
            startActivity(i);


        }else if (id == R.id.nav_about) {
            Intent i = new Intent(this, AboutUs.class);
            startActivity(i);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}








