package com.ylmzkurt.piano;

import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button button1, button2, button3, button4;
    private SoundPool soundPool;
    private int soundDo, soundRe, soundMi, soundSol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        soundPool = new SoundPool.Builder()
                .setMaxStreams(1)
                .setAudioAttributes(new AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                        .build())
                .build();

        // Ses dosyasını yükle
        soundDo = soundPool.load(this, R.raw.do_note, 1);
        soundRe = soundPool.load(this, R.raw.re, 1);
        soundMi = soundPool.load(this, R.raw.mi, 1);
        soundSol = soundPool.load(this, R.raw.sol, 1);
    }

    public void button1(View view) {
        button1.setOnClickListener(v -> soundPool.play(soundDo, 1, 1, 0, 0, 1));
    }
    public void button2(View view) {
        button2.setOnClickListener(v -> soundPool.play(soundRe, 1, 1, 0, 0, 1));
    }
    public void button3(View view) {
        button3.setOnClickListener(v -> soundPool.play(soundMi, 1, 1, 0, 0, 1));
    }
    public void button4(View view) {
        button4.setOnClickListener(v -> soundPool.play(soundSol, 1, 1, 0, 0, 1));
    }


}