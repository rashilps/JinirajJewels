package com.jinirajjewels.jinirajjewels;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by rashil on 30/3/18.
 */

public class BuyNow extends AppCompatActivity {

    TextView tv;
    LinearLayout ll;
    LinearLayout ll1;

    public void init() {
        tv = (TextView) findViewById(R.id.email);

        // Capture button clicks
        tv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "jinirajimpex@gmail.com", null));
                startActivity(Intent.createChooser(intent, "Choose an Email client :"));
            }
        });
    }
    public static Intent openFacebook(Context context){
        try {
            context.getPackageManager()
                    .getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("fb://page/952684951529188"));
        } catch (Exception e){

            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/Jinirajjewels"));
        }

    }
    public void init2() {
        ll = (LinearLayout) findViewById(R.id.facebook);

        // Capture button clicks
        ll.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent facebookIntent = openFacebook(BuyNow.this);
                startActivity(facebookIntent);
            }
        });
    }
    public void init3() {
        ll1 = (LinearLayout) findViewById(R.id.instagram);

        // Capture button clicks
        ll1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Uri uri = Uri.parse("http://instagram.com/_u/jinirajjewels");


                Intent i= new Intent(Intent.ACTION_VIEW,uri);

                i.setPackage("com.instagram.android");

                try {
                    startActivity(i);
                } catch (ActivityNotFoundException e) {

                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/jinirajjewels")));
                }
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_now);
        init();
        init2();
        init3();
    }
}
