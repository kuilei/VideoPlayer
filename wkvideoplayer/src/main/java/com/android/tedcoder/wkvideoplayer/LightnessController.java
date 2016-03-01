package com.android.tedcoder.wkvideoplayer;

import android.app.Activity;
import android.content.ContentResolver;
import android.provider.Settings;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by zhu.yi on 16-2-29.
 */
public class LightnessController
{
    /**
     * 判断是否开启了自动亮度调节
     * @param act
     * @return
     */
    public static boolean isAutoBrightness(Activity act)
    {
        boolean automicBrightness = false;
        ContentResolver contentResolver = act.getContentResolver();
        try
        {
            automicBrightness = Settings.System.getInt(contentResolver,Settings.System.SCREEN_BRIGHTNESS_MODE)
                    == Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC;
        }catch (Exception e)
        {
            Toast.makeText(act,"无法获取亮度",Toast.LENGTH_SHORT).show();
        }
        return automicBrightness;
    }

    /**
     * 改变亮度
     * @param act
     * @param value
     */
    public static void setLightness(Activity act,int value)
    {
        try
        {
            Settings.System.putInt(act.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, value);
            WindowManager.LayoutParams lp = act.getWindow().getAttributes();
            lp.screenBrightness = (value <= 0? 1: value)/255f;
            act.getWindow().setAttributes(lp);
        }catch (Exception e)
        {
            Toast.makeText(act,"无法改变亮度",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 获取亮度
     * @param act
     * @return
     */
    public static int getLightness(Activity act)
    {
        return Settings.System.getInt(act.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS,-1);
    }

    /**
     * 停止自动亮度调节
     * @param act
     */
    public static void stopAutoBrightness(Activity act)
    {
        Settings.System.putInt(act.getContentResolver(),Settings.System.SCREEN_BRIGHTNESS_MODE,Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
    }

    /**
     * 开启亮度自动调节
     * @param act
     */
    public static void startAutoBrightness(Activity act)
    {
        Settings.System.putInt(act.getContentResolver(),Settings.System.SCREEN_BRIGHTNESS_MODE,Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC);
    }
}
