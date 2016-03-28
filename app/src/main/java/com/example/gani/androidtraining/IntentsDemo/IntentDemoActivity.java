package com.example.gani.androidtraining.IntentsDemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gani.androidtraining.R;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class IntentDemoActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 200;

    ImageView imgViewBitMap;
    Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_demo);

        Button btnGetData = (Button)findViewById(R.id.buttonGetData);
        Button btnShareData = (Button)findViewById(R.id.buttonShareData);

        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getIntent().getExtras();
                if (bundle != null) {
                    String stringExtra = bundle.getString("data");
                    Toast.makeText(getBaseContext(),"Yes, You received the data from last activity i.e " + stringExtra,Toast.LENGTH_LONG).show();
                }
            }
        });

        //Share Action
        btnShareData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentShare = new Intent(Intent.ACTION_SEND);
                intentShare.setType("text/plain");
                intentShare.putExtra(android.content.Intent.EXTRA_TEXT,"News for you !!!!");
                startActivity(intentShare);
            }
        });

        //Set Image views
        imgViewBitMap = (ImageView) findViewById(R.id.imageView);

    }


    public void pickImage(View view) {

        Intent newIntentToPickImage = new Intent();
        newIntentToPickImage.setType("image/*");
        newIntentToPickImage.setAction(Intent.ACTION_GET_CONTENT);
        newIntentToPickImage.addCategory(Intent.CATEGORY_OPENABLE);

        startActivityForResult(newIntentToPickImage,REQUEST_CODE);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        InputStream stream = null;
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            try {
                if (bitmap != null) {
                    bitmap.recycle();
                }
                stream = getContentResolver().openInputStream(data.getData());
                bitmap = BitmapFactory.decodeStream(stream);

                //Now you set to image view
                imgViewBitMap.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //OnFinish
    @Override
    public void finish() {
        Intent newReturnInt = new Intent();
        newReturnInt.putExtra("returnData","This is returned data from ..... !!!!!!!! ");
        setResult(RESULT_OK,newReturnInt);
        super.finish();
    }
}
