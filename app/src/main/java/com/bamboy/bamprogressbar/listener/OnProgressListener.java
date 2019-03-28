package com.bamboy.bamprogressbar.listener;

import com.bamboy.bamprogressbar.progress.BaseProgress;

/**
 * 进度改变时的监听
 * <p>
 * Created by Bamboy on 2018/4/4.
 */
public interface OnProgressListener {

    /**
     * 监听变化时回调
     *
     * @param progressBar
     * @param progress
     */
    void onProgress(BaseProgress progressBar, int progress);
}
