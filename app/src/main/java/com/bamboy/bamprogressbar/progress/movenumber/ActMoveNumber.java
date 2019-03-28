package com.bamboy.bamprogressbar.progress.movenumber;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bamboy.bamprogressbar.R;
import com.bamboy.bamprogressbar.listener.OnProgressListener;
import com.bamboy.bamprogressbar.progress.BaseProgress;

public class ActMoveNumber extends AppCompatActivity {

    /**
     * 移动数字进度条
     */
    private MoveNumberProgressBar movenumber_progress;

    /**
     * 进度条监听指示文字
     */
    private TextView tv_value;
    /**
     * 直接控制进度条的SeekBar
     */
    private SeekBar sb_progress;
    /**
     * 控制进度条【后退】的按钮
     */
    private Button btn_retreat;
    /**
     * 控制进度条【前进】的按钮
     */
    private Button btn_advance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_move_number);
        setTitle("移动数字进度条");
        // 添加返回按钮
        initBack();

        movenumber_progress = findViewById(R.id.movenumber_progress);
        tv_value = findViewById(R.id.tv_value);
        sb_progress = findViewById(R.id.sb_progress);
        btn_retreat = findViewById(R.id.btn_retreat);
        btn_advance = findViewById(R.id.btn_advance);

        // 设置进度条的监听器
        movenumber_progress.setProgressListener(new OnProgressListener() {
            @Override
            public void onProgress(BaseProgress progressBar, int progress) {
                // 显示进度
                tv_value.setText("监听：" + progress + "/" + progressBar.getProgressMax());
            }
        });

        // 滑动监听
        sb_progress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                // 设置进度
                movenumber_progress.setProgress(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        // 后退按钮
        btn_retreat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (movenumber_progress.getProgress() > 0) {
                    // 利用属性动画控制进度条后退
                    ObjectAnimator.ofFloat(
                            movenumber_progress,
                            "progress",
                            movenumber_progress.getProgress(),
                            movenumber_progress.getProgress() - 29)
                            .setDuration(250)
                            .start();
                }
            }
        });

        // 前进按钮
        btn_advance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (movenumber_progress.getProgress() < movenumber_progress.getProgressMax()) {
                    // 利用属性动画控制进度条前进
                    ObjectAnimator
                            .ofFloat(
                                    movenumber_progress,
                                    "progress",
                                    movenumber_progress.getProgress(),
                                    movenumber_progress.getProgress() + 29)
                            .setDuration(250)
                            .start();
                }
            }
        });

    }

    /**
     * TitleBar添加返回按钮
     */
    private void initBack() {
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * TitleBar返回按钮点击事件
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
