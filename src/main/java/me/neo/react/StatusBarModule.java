package me.neo.react;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;

/**
 * Created by Nishanth Shankar on 9/24/15.
 */
public class StatusBarModule extends ReactContextBaseJavaModule {
    Activity mActivity = null;
    public StatusBarModule(ReactApplicationContext reactContext, Activity activity) {
        super(reactContext);
        mActivity = activity;
    }

    @Override
    public String getName() {
        return "StatusBarAndroid";
    }

    @ReactMethod
    public void setHexColor(String hex){
        int color = Color.parseColor(hex);
        setStatusColor(color);
    }

    @ReactMethod
    public void setRGB(int r, int g, int b){
        int color = Color.rgb(r,g,b);
        setStatusColor(color);
    }

    @ReactMethod
    public void setARGB(int a,int r, int g, int b){
        int color = Color.argb(a, r, g, b);
        setStatusColor(color);
    }

    void setStatusColor(final int color){
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(Build.VERSION.SDK_INT >= 21){
                    Window window = mActivity.getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(color);

                }

            }
        });

    }


    @ReactMethod
    public void hideStatusBar(){
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                View decorView = mActivity.getWindow().getDecorView();
                // Hide the status bar.
                int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
                decorView.setSystemUiVisibility(uiOptions);
            }
        });
    }

    @ReactMethod
    public void showStatusBar(){
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(Build.VERSION.SDK_INT < 16)
                    return;
                View decorView = mActivity.getWindow().getDecorView();
                // Hide the status bar.
                int uiOptions = View.SYSTEM_UI_FLAG_VISIBLE;
                decorView.setSystemUiVisibility(uiOptions);
            }
        });
    }
}
