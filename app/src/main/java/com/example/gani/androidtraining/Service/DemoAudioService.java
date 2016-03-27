package com.example.gani.androidtraining.Service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.gani.androidtraining.R;

/**
 * Created by gani on 26/03/16.
 */
public class DemoAudioService extends Service {

    //Binder
    Binder mBinder = new MyLocalBinder();

    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }


    public class MyLocalBinder extends Binder {

        public  DemoAudioService getMyLocalSercice() {
            return DemoAudioService.this;
        }
    }

    public void startAudio() {
        mediaPlayer.start();
    }

    public void stopAudio() {
        mediaPlayer.stop();
    }

    @Override
    public void onCreate() {
        //super.onCreate();
        Toast.makeText(this,"The service is created !!!!",Toast.LENGTH_LONG).show();
         mediaPlayer = MediaPlayer.create(this,R.raw.mohabbateinlovethemeinstrumental);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"On start command is fired !!!!",Toast.LENGTH_LONG).show();
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"ohh. .....The service is destroyed !!!!",Toast.LENGTH_LONG).show();
        mediaPlayer.stop();
      /* super.onDestroy(); */
    }



}
