package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    private String getRandom(){
        int n=rand.nextInt(3)+1;
        if(n == 1 ){  return "paper";}
        else if(n == 2 ){  return "scissor";}
        else{ return "rock";}
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
    private void whoWon(String player)  {
        String computer=getRandom();
        if (computer.equals(player)){
            updateScore(1,1);
            l= findViewById(R.id.l);
            l.setBackgroundColor(Color.parseColor("#F4A111"));
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 5s = 5000ms
                    l.setBackgroundColor(Color.parseColor("#00F41111"));
                }
            }, 1000);


        } else if ((player.equals("paper") && computer.equals("rock"))||(player.equals("scissor") && computer.equals("paper"))||(player.equals("rock") && computer.equals("scissor"))){
            updateScore(0,1);
            l= findViewById(R.id.l);
            l.setBackgroundColor(Color.parseColor("#A4ED1E"));

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 5s = 5000ms
                    l.setBackgroundColor(Color.parseColor("#00F41111"));
                }
            }, 1000);

        }else{
            updateScore(1,0);
            l= findViewById(R.id.l);
            l.setBackgroundColor(Color.parseColor("#F41111"));

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 5s = 5000ms
                    l.setBackgroundColor(Color.parseColor("#00F41111"));
                }
            }, 1000);



        }
    }
    public void paper(View view) {
        whoWon("paper");
    }
    public void scissor(View view) {
        whoWon("scissor");
    }
    public void rock(View view) {

        whoWon("rock");
    }
}