package com.bamboy.bamprogressbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bamboy.bamprogressbar.progress.movenumber.ActMoveNumber;
import com.bamboy.bamprogressbar.progress.noun.ActNoun;
import com.bamboy.bamprogressbar.progress.slope.ActSlope;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initBtn();
    }

    /**
     * 初始化按钮
     */
    private void initBtn() {
        findViewById(R.id.btn_noun).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ActNoun.class));
            }
        });

        findViewById(R.id.btn_slope).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ActSlope.class));
            }
        });

        findViewById(R.id.btn_movenumber).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ActMoveNumber.class));
            }
        });
    }

}
