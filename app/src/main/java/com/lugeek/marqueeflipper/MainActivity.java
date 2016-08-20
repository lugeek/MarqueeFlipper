package com.lugeek.marqueeflipper;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MarqueeFlipperView mFlipperView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFlipperView = (MarqueeFlipperView) findViewById(R.id.mfv);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<String> data = new ArrayList<>();
                data.add("iPhone8最感人变化成真，必须买买买买!!!!");
                data.add("简直是白菜价！日本玩家33万甩卖15万张游戏王卡");
                data.add("iPhone7价格曝光了！看完感觉我的腰子有点疼...");
                mFlipperView.setVisibility(View.VISIBLE);
                mFlipperView.setOnFlipperClickListener(new MarqueeFlipperView.OnFlipperClickListener() {
                    @Override
                    public void onClick(String title, int position) {
                        Toast.makeText(MainActivity.this, title, Toast.LENGTH_SHORT).show();
                    }
                });
                mFlipperView.setData(data);
            }
        }, 2000);
    }
}
