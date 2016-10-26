package com.z.loadlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.z.loadlayoutlibrary.LoadLayout;

public class MainActivity extends AppCompatActivity {
    private LoadLayout mLoadlayoutLoadLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLoadlayoutLoadLayout = (LoadLayout) findViewById(R.id.loadlayout);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mLoadlayoutLoadLayout.showLoading();
                        }
                    });
                    Thread.sleep(2000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mLoadlayoutLoadLayout.showEmpty();
                        }
                    });
                    Thread.sleep(2000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mLoadlayoutLoadLayout.showError();
                        }
                    });
                    Thread.sleep(2000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mLoadlayoutLoadLayout.showContent();
                        }
                    });


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
