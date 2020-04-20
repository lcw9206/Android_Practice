package com.example.practice.appstore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practice.R;

public class AppStoreActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appstore);

        ImageButton appStoreBackBtn = findViewById(R.id.appstore_back_btn);
        appStoreBackBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.appstore_back_btn:
                Intent intent = new Intent();

                intent.putExtra("requestCode", "Exit");

                setResult(Activity.RESULT_OK, intent);

                // startActivityForResult => AppStore에서 Main으로 돌아올 때 응답을 받기 위함
                // request 코드를 받음으로써 화면을 분기해 처리 가
                finish();
        }
    }
}
