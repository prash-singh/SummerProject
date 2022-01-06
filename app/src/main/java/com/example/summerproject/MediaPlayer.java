package com.example.summerproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MediaPlayer extends AppCompatActivity {
    Button b1,b2,b3;
    VideoView v1;
    MediaController m1;
    Uri u1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);

        b1 = (Button) findViewById(R.id.button32);
        b2 = (Button) findViewById(R.id.button33);
        b3 = (Button) findViewById(R.id.button34);
        v1 = (VideoView) findViewById(R.id.videoView);
        m1 = new MediaController(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaPlayer.this,Third.class);
                startActivity(i);
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(i,0);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video1));
                v1.setMediaController(m1);
                m1.setAnchorView(v1);
                v1.start();
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        u1 = data.getData();
        v1.setVideoURI(u1);
        v1.setMediaController(m1);
        m1.setAnchorView(v1);
        v1.start();

    }

}