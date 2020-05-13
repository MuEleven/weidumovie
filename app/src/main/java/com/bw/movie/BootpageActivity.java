package com.bw.movie;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BootpageActivity extends AppCompatActivity {
    @BindView(R.id.text)
    TextView text;
    private int i = 5;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            i--;
            text.setText("跳转"+i+"S");
            //倒计时时间
            handler.sendEmptyMessageDelayed(0,1000);
            if (i==0) {
                Intent intent = new Intent(BootpageActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }else {
                text.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(BootpageActivity.this, HomeActivity.class);
                        startActivity(intent);

                        handler.removeCallbacksAndMessages(null);
                        finish();
                    }
                });
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bootpage);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        handler.sendEmptyMessageDelayed(0,1000);
    }
}
