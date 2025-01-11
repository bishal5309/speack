package com.example.texttospeack;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Queue;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Button btn;

    TextToSpeech textToSpeech;
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


        textToSpeech = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

            }
        });


        et = findViewById(R.id.et);
        btn = findViewById(R.id.btn);



        btn.setOnClickListener(view -> {
             String et1 = et.getText().toString().trim();

             if ( et1.isBlank()){
                 speakText("input something");
                 return;
             }
             speakText(et1);

        });







    }

    private void speakText (String text){
        textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null , null);
    }
}