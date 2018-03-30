package com.jinirajjewels.jinirajjewels;

/**
 * Created by rashil on 11/3/18.
 */

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.github.chrisbanes.photoview.PhotoView;

/**
 * Created by Chike on 2/12/2017.
 */

public class BanglesPhotoActivity extends AppCompatActivity {

    public static final String EXTRA_BANGLES_PHOTO = "BanglesPhotoActivity.BANGLES_PHOTO";
    Button button;

    public void init() {
        button = (Button) findViewById(R.id.MyButton);

        // Capture button clicks
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Contact us through E-mail or Phone",
                        Toast.LENGTH_SHORT).show();
                // Start NewActivity.class
                Intent myIntent = new Intent(BanglesPhotoActivity.this, BuyNow.class);
                startActivity(myIntent);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);

        final PhotoView photoView = findViewById(R.id.image);

        BanglesPhoto banglesPhoto = getIntent().getParcelableExtra(EXTRA_BANGLES_PHOTO);
        init();

        Glide.with(this)
                .asBitmap()
                .load(banglesPhoto.getUrl())
                .listener(new RequestListener<Bitmap>() {


                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                        onPalette(Palette.from(resource).generate());
                        photoView.setImageBitmap(resource);

                        return false;
                    }


                    public void onPalette(Palette palette) {
                        if (null != palette) {
                            ViewGroup parent = (ViewGroup) photoView.getParent().getParent();
                            parent.setBackgroundColor(palette.getDarkVibrantColor(Color.GRAY));
                        }
                    }
                })
                .into(photoView);

    }


   /* private SimpleTarget target = new SimpleTarget<Bitmap>() {

        @Override
        public void onResourceReady(Bitmap bitmap, GlideAnimation glideAnimation) {

           onPalette(Palette.from(bitmap).generate());
           mImageView.setImageBitmap(bitmap);
        }

        public void onPalette(Palette palette) {
            if (null != palette) {
                ViewGroup parent = (ViewGroup) mImageView.getParent().getParent();
                parent.setBackgroundColor(palette.getDarkVibrantColor(Color.GRAY));
            }
        }
    };*/
}

