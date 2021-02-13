package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import android.graphics.Color;
import android.os.Handler;

import static java.lang.Thread.sleep;


public class MainActivity extends AppCompatActivity {
    Random rand = new Random();

    int computerScore=0,playerScore=0;
    TextView computerTextView,playerTextView;
    LinearLayout l;
    ImageView Image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    private int getRandom(){
        return rand.nextInt(3)+1;

    }
    @SuppressLint("SetTextI18n")
    private void updateScore(int computer , int player){
        computerScore+= computer;
        playerScore+=player;

        TextView computerTextView= (TextView) findViewById(R.id.computerScore);
        TextView playerTextView=(TextView)findViewById(R.id.playerScore);
        computerTextView.setText("computer "+computerScore);
        playerTextView.setText("you "+playerScore);
    }
    @SuppressLint("ResourceAsColor")
    private void whoWon(int player)  {
        int computer=getRandom();
        l= findViewById(R.id.l);
        if (computer==3){ Image=findViewById(R.id.rock); }
        if(computer==2){Image=findViewById(R.id.scissors);}
        if(computer==1) {Image=findViewById(R.id.paper);}
        Image.setVisibility(View.VISIBLE);
        if (computer==player){
            updateScore(1,1);

            l.setBackgroundColor(Color.parseColor("#F4A111"));
        } else if ((player==1 && computer==3)||(player==2 && computer==1)||(player==3 && computer==2)){
            updateScore(0,1);

            l.setBackgroundColor(Color.parseColor("#A4ED1E"));

        }else{
            updateScore(1,0);

            l.setBackgroundColor(Color.parseColor("#F41111"));

        }
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                Image.setVisibility(View.INVISIBLE);
                l.setBackgroundColor(Color.parseColor("#00F41111"));
            }
        }, 1000);
    }
    public void paper(View view) {
        whoWon(1);
    }
    public void scissor(View view) {
        whoWon(2);
    }
    public void rock(View view) {

        whoWon(3);
    }
}