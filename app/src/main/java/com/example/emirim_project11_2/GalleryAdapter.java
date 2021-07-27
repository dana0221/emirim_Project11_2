package com.example.emirim_project11_2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GalleryAdapter extends BaseAdapter {
    Context context;
    int[] posterIds = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8, R.drawable.image9, R.drawable.image10};
    int[] titleIds = {R.string.title1, R.string.title2, R.string.title3, R.string.title4, R.string.title5, R.string.title6, R.string.title7, R.string.title8, R.string.title9, R.string.title10};
    ImageView imgvLarge;

    public GalleryAdapter(Context context, ImageView imgvLarge){
        this.context = context;
        this.imgvLarge = imgvLarge;
    }

    @Override
    public int getCount() {
        return posterIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ImageView imgv = new ImageView(context);
        imgv.setLayoutParams(new Gallery.LayoutParams(200, 300));
        imgv.setImageResource(posterIds[i]);
        imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);

        final int pos = i;
        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgvLarge.setImageResource(posterIds[pos]);
                Toast toast = new Toast(context);
                View toastView = View.inflate(context, R.layout.toast1, null);
                TextView textTitle = toastView.findViewById(R.id.text_title);
                textTitle.setText(titleIds[pos]);
                toast.setView(toastView);
                toast.show();
            }
        });

        return imgv;
    }
}
