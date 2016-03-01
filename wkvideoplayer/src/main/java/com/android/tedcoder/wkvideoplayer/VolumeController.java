package com.android.tedcoder.wkvideoplayer;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.android.tedcoder.wkvideoplayer.view.VolumeView;

/**
 * Created by zhu.yi on 16-2-29.
 */
public class VolumeController
{
    private Toast t;
    private VolumeView tv;

    private Context mContext;

    public VolumeController(Context mContext)
    {
        this.mContext = mContext;
    }

    public void show(float progress)
    {
        if (t == null)
        {
            t = new Toast(mContext);
            View layout = LayoutInflater.from(mContext).inflate(R.layout.video_volumn_view,null);
            tv = (VolumeView) layout.findViewById(R.id.volume_view);
            t.setView(layout);
            t.setGravity(Gravity.BOTTOM, 0, 100);
            t.setDuration(Toast.LENGTH_SHORT);
        }
        tv.setProgress(progress);
        t.show();
    }
}
