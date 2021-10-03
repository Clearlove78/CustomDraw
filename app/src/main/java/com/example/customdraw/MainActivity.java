package com.example.customdraw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends AppCompatActivity {
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView)findViewById(R.id.image1);
        ViewGroup.MarginLayoutParams margin9 = new ViewGroup.MarginLayoutParams(
                image.getLayoutParams());
        margin9.setMargins(500, 2000, 0, 0);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(margin9);
        layoutParams9.height = 400;
        layoutParams9.width = 400;
        image.setLayoutParams(layoutParams9);

    }
}