package com.bamboy.bamprogressbar.progress.slope;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bamboy.bamprogressbar.R;
import com.bamboy.bamprogressbar.listener.OnProgressListener;
import com.bamboy.bamprogressbar.progress.BaseProgress;
import com.bamboy.bamprogressbar.progress.noun.NounProgressBar;

import java.io.InputStream;
import java.util.Random;

public class ActSlope extends AppCompatActivity {
    /**
     * 进度条
     */
    private SlopeProgress slope_progress;
    /**
     * 进度条标题
     */
    private TextView tv_title;
    /**
     * 进度条副标题
     */
    private TextView tv_subtitle;
    /**
     * 切换进度条样式的按钮
     */
    private Button btn_change;

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
        setContentView(R.layout.act_slope);
        setTitle("圆形进度条");
        // 添加返回按钮
        initBack();

        // 初始化View
        findView();

        // 初始化【切换】按钮
        initChangeBtn();

        // 初始化进度条的监听器
        initListener();

        // 初始化拖动条
        initSeekBar();

        // 初始化【前进】和【后退】按钮
        initRetreatAndAdvanceBtn();
    }

    /**
     * 初始化View
     */
    private void findView() {
        tv_title = findViewById(R.id.tv_title);
        tv_subtitle = findViewById(R.id.tv_subtitle);
        btn_change = findViewById(R.id.btn_change);

        slope_progress = findViewById(R.id.slope_progress);
        tv_value = findViewById(R.id.tv_value);
        sb_progress = findViewById(R.id.sb_progress);
        btn_retreat = findViewById(R.id.btn_retreat);
        btn_advance = findViewById(R.id.btn_advance);
    }

    /**
     * 初始化【切换】按钮
     */
    private void initChangeBtn() {
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (slope_progress.getImgType()) {
                    case SlopeProgress.IMGTYPE_NOT:

                        // 切换成对号
                        slope_progress.setImgType(SlopeProgress.IMGTYPE_SUCCESS);
                        tv_subtitle.setText("图像：对号");
                        break;
                    case SlopeProgress.IMGTYPE_SUCCESS:

                        // 切换成叉号
                        slope_progress.setImgType(SlopeProgress.IMGTYPE_ERROR);
                        tv_subtitle.setText("图像：叉号");
                        break;
                    case SlopeProgress.IMGTYPE_ERROR:

                        // 切换成数字进度
                        slope_progress.setImgType(SlopeProgress.IMGTYPE_PROGRESS);
                        tv_subtitle.setText("图像：数字进度");
                        break;
                    case SlopeProgress.IMGTYPE_PROGRESS:

                        // 切换成图片
                        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img_home);
                        slope_progress.setPicture(bitmap);
                        tv_subtitle.setText("图像：图片");
                        break;
                    case SlopeProgress.IMGTYPE_PICTURE:

                        // 切换成空图像
                        slope_progress.setImgType(SlopeProgress.IMGTYPE_NOT);
                        tv_subtitle.setText("图像：空");
                        break;
                }
            }
        });
    }

    /**
     * 初始化进度条的监听器
     */
    private void initListener() {
        slope_progress.setProgressListener(new OnProgressListener() {
            @Override
            public void onProgress(BaseProgress progressBar, int progress) {
                // 显示进度
                tv_value.setText("监听：" + progress + "/" + progressBar.getProgressMax());
            }
        });
    }

    /**
     * 初始化拖动条
     */
    private void initSeekBar() {
        sb_progress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                // 设置进度
                slope_progress.setProgress(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    /**
     * 初始化【前进】和【后退】按钮
     */
    private void initRetreatAndAdvanceBtn() {
        // 后退按钮
        btn_retreat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int changeValue = 0 - (int)(slope_progress.getProgressMax() * 0.395f);

                // 动画控制进度
                animProgress(slope_progress, changeValue);
            }
        });

        // 前进按钮
        btn_advance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int changeValue = (int)(slope_progress.getProgressMax() * 0.395f);

                // 动画控制进度
                animProgress(slope_progress, changeValue);
            }
        });
    }

    /**
     * 动画控制进度
     *
     * @param progress    进度条View
     * @param changeValue 改变的值
     */
    private void animProgress(SlopeProgress progress, int changeValue) {
        // 利用属性动画控制进度条
        ObjectAnimator
                .ofFloat(
                        progress,
                        "progress",
                        progress.getProgress(),
                        progress.getProgress() + changeValue)
                .setDuration(250)
                .start();
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
