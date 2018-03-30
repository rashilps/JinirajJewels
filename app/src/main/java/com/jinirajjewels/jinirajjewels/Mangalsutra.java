package com.jinirajjewels.jinirajjewels;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by rashil on 16/12/17.
 */

public class Mangalsutra extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangalsurta);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_images);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        Mangalsutra.ImageGalleryAdapter adapter = new Mangalsutra.ImageGalleryAdapter(this, MangalsutraPhoto.getSpacePhotos());
        recyclerView.setAdapter(adapter);
    }

    private class ImageGalleryAdapter extends RecyclerView.Adapter<ImageGalleryAdapter.MyViewHolder>  {

        @Override
        public ImageGalleryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);

            // Inflate the layout
            View photoView = inflater.inflate(R.layout.customitemlayout, parent, false);

            ImageGalleryAdapter.MyViewHolder viewHolder = new ImageGalleryAdapter.MyViewHolder(photoView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ImageGalleryAdapter.MyViewHolder holder, int position) {

            MangalsutraPhoto mangalsutraPhoto = mSpacePhotos[position];
            ImageView imageView = holder.mPhotoImageView;

            Glide.with(mContext)
                    .load(mangalsutraPhoto.getUrl())
                    .apply(new RequestOptions()
                            .placeholder(R.drawable.jiniraj))
                    .into(imageView);
        }

        @Override
        public int getItemCount() {
            return (mSpacePhotos.length);
        }

        public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            public ImageView mPhotoImageView;

            public MyViewHolder(View itemView) {

                super(itemView);
                mPhotoImageView = (ImageView) itemView.findViewById(R.id.iv_photo);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Pinch to zoom",
                        Toast.LENGTH_SHORT).show();
                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION) {
                    MangalsutraPhoto mangalsutraPhoto = mSpacePhotos[position];

                    Intent intent = new Intent(mContext, MangalsutraPhotoActivity.class);
                    intent.putExtra(MangalsutraPhotoActivity.EXTRA_MANGALSUTRA_PHOTO, mangalsutraPhoto);
                    startActivity(intent);
                }
            }
        }

        private MangalsutraPhoto[] mSpacePhotos;
        private Context mContext;

        public ImageGalleryAdapter(Context context, MangalsutraPhoto[] mangalsutraPhotos) {
            mContext = context;
            mSpacePhotos = mangalsutraPhotos;
        }
    }
}