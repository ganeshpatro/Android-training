package com.example.gani.androidtraining.activities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Switch;

import com.example.gani.androidtraining.R;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class BackgroundProcessActivity extends AppCompatActivity implements View.OnClickListener{

    private ProgressBar mProgressBar;
    private Button btnDownloadImage;
    private Button btnResetDownloadingImage;
    private ImageView mImageView;

    private static Bitmap bitMapDownload;
    private static Handler mHandler;
    private static MyDownloadThread myDownloadThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_process);

        initialiseComponents();

        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                mImageView.setImageBitmap(bitMapDownload);
                mProgressBar.setVisibility(View.GONE);
            }
        };
    }

    @Override
    protected void onDestroy() {
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.GONE);
            mProgressBar = null;
        }
        super.onDestroy();
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return myDownloadThread;
    }

    private void initialiseComponents() {
        mProgressBar = (ProgressBar) findViewById(R.id.progressBarImageDownloading);
        btnDownloadImage = (Button) findViewById(R.id.btnDownloadTheImage);
        if (btnDownloadImage != null) {
            btnDownloadImage.setOnClickListener(this);
        }
        btnResetDownloadingImage = (Button) findViewById(R.id.btnResetDownloadingTheImage);
        if (btnResetDownloadingImage != null) {
            btnResetDownloadingImage.setOnClickListener(this);
        }
        mImageView = (ImageView) findViewById(R.id.imageViewBitMapDownload);
        Context context = mImageView.getContext();
        System.out.println(context);
    }

    public void startDownloadingTheImage() {
        mProgressBar.setProgress(50);
        myDownloadThread = new MyDownloadThread();
        myDownloadThread.start();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btnDownloadTheImage:{
                startDownloadingTheImage();
            }
            break;

            case R.id.btnResetDownloadingTheImage:{

            }
            break;
        }
    }

    /**
     * New Custom Thread Class to call the downloading operation method
     */
    static public class MyDownloadThread extends Thread {
        @Override
        public void run() {
            //First simulate a slow work
            try {
                new Thread().sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                bitMapDownload =  downloadBitMapFrom("http://api.androidhive.info/progressdialog/hive.jpg");
                mHandler.sendEmptyMessage(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Util Method to dowbnload the image from URL
     */
    static private Bitmap downloadBitMapFrom(String urlImage) throws IOException {
        Bitmap bitmap = null;
        int count;
        try {
            URL url = new URL(urlImage);
            URLConnection conection = url.openConnection();
            conection.connect();
            // getting file length
            int lenghtOfFile = conection.getContentLength();

            // input stream to read file - with 8k buffer
            InputStream input = new BufferedInputStream(url.openStream(), 8192);

            // Output stream to write file
            OutputStream output = new FileOutputStream("/sdcard/downloadedfile.jpg");

            byte data[] = new byte[1024];

            long total = 0;

            while ((count = input.read(data)) != -1) {
                total += count;
                // publishing the progress....
                // After this onProgressUpdate will be called
             //   publishProgress(""+(int)((total*100)/lenghtOfFile));

                // writing data to file
                output.write(data, 0, count);
            }

            // flushing output
            output.flush();

            // closing streams
            output.close();
            input.close();


            String imagePath = Environment.getExternalStorageDirectory().toString() + "/downloadedfile.jpg";
            Drawable drawable = Drawable.createFromPath(imagePath);
            bitmap = ((BitmapDrawable)drawable).getBitmap();

            return bitmap;

        } catch (Exception e) {
            Log.e("Error: ", e.getMessage());
        }

        return bitmap;
    }

}
