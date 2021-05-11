package com.example.dialer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.Manifest;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    ArrayList<TextView> numbs = new ArrayList<>();
    ImageButton btnBack,btnCall;
    TextView num;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestPermissions(new String[]{Manifest.permission.CALL_PHONE},1024);

        numbs.add(findViewById(R.id.num1));
        numbs.add(findViewById(R.id.num2));
        numbs.add(findViewById(R.id.num3));
        numbs.add(findViewById(R.id.num4));
        numbs.add(findViewById(R.id.num5));
        numbs.add(findViewById(R.id.num6));
        numbs.add(findViewById(R.id.num7));
        numbs.add(findViewById(R.id.num8));
        numbs.add(findViewById(R.id.num9));
        numbs.add(findViewById(R.id.num0));
        numbs.add(findViewById(R.id.numPlus));
        numbs.add(findViewById(R.id.num_hs));
        numbs.add(findViewById(R.id.num_st));

        btnBack = findViewById(R.id.btnBack);
        btnCall = findViewById(R.id.btnCall);

        num = findViewById(R.id.num);

        for(TextView t:numbs)
            t.setOnClickListener(this);

        btnCall.setOnClickListener(this);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.num0:
                num.setText(num.getText()+"0");
                break;
            case R.id.num1:
                num.setText(num.getText()+"1");
                break;
            case R.id.num2:
                num.setText(num.getText()+"2");
                break;
            case R.id.num3:
                num.setText(num.getText()+"3");
                break;
            case R.id.num4:
                num.setText(num.getText()+"4");
                break;
            case R.id.num5:
                num.setText(num.getText()+"5");
                break;
            case R.id.num6:
                num.setText(num.getText()+"6");
                break;
            case R.id.num7:
                num.setText(num.getText()+"7");
                break;
            case R.id.num8:
                num.setText(num.getText()+"8");
                break;
            case R.id.num9:
                num.setText(num.getText()+"9");
                break;
            case R.id.num_hs:
                num.setText(num.getText()+"#");
                break;
            case R.id.num_st:
                num.setText(num.getText()+"*");
                break;
            case R.id.numPlus:
                num.setText(num.getText()+"+");
                break;
            case R.id.btnBack:
                if(num.getText().toString().length() > 0)
                    num.setText(num.getText().toString().substring(0,num.getText().length()-1));
                break;
            case R.id.btnCall:
                call(num.getText().toString());
                break;
        }
    }

    public void  call(@NotNull String number){
        if(!number.isEmpty()){
            if(!number.startsWith("+91")){
                 number = "+91" + number;
            }
            Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+number));
            startActivity(intent);
        }
    }
}