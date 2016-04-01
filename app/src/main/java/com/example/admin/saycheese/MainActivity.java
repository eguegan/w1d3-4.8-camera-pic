package com.example.admin.saycheese;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Uri imgLocation;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Button capture = (Button) findViewById(R.id.am_btn_camera);
        capture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                imgLocation = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "fname_" +
                        String.valueOf(System.currentTimeMillis()) + ".jpg"));

                intent.putExtra(MediaStore.EXTRA_OUTPUT, imgLocation);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {

            Log.e("URI",imgLocation.toString());
            mImageView.setImageBitmap(BitmapFactory.decodeFile(imgLocation.toString()));
        }
    }
}
