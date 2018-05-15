package com.jinirajjewels.jinirajjewels;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    static final int REQUEST_PERMISSION_KEY = 1;
    String[] text = {"Rings", "Bangles", "Earrings", "Mangalsutra", "Necklace", "Pendant"};
    int[] ImageId = {R.drawable.rings, R.drawable.bangles, R.drawable.earrings, R.drawable.mangalsutra2, R.drawable.necklace1, R.drawable.pendant3};
    private String[] imageUrls = new String[]{
            "https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/necklace1.jpg?alt=media&token=cabe073a-826f-49b2-adaa-cc2916389fc7",
            "https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/bangles4%20(1).jpg?alt=media&token=a3d39858-db3e-4b8e-8dd8-898e35824070",
            "https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/earring3.jpg?alt=media&token=6391fc18-6fa6-4a03-ab43-335f814b1d84",
            "https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/IMG-20170203-WA0073.jpg?alt=media&token=6375e934-4741-4f7a-ab57-e500e8174fa1",
            "https://firebasestorage.googleapis.com/v0/b/jinirajjewels.appspot.com/o/ring15.jpg?alt=media&token=e7ed589c-961b-4d60-bd1f-245cc722912d"
    };
    private static ViewPager mPager;
    private static DotsIndicator  dotsIndicator;
    private static int currentPage = 0;
    GridView grid;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;



    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.pager);
        ViewPagerAdapter adapter1 = new ViewPagerAdapter(this, imageUrls);
        viewPager.setAdapter(adapter1);

        sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);

        dotscount = adapter1.getCount();
        dots = new ImageView[dotscount];
        for(int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

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








