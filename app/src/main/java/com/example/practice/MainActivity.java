package com.example.practice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.practice.appstore.AppStoreActivity;
import com.example.practice.common.CodeList;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

// 복수의 activity를 호출하는 Activity라는 가정하에 OnclickListener 상속
// 상속을 통해 하나의 onClick 메서드 안에서 모든 클릭 이벤트 처리가능
public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // activity_main.xml 정의

        Button appStoreBtn = findViewById(R.id.main_side_appstore_btn); // main_side의 appstore_btn 객체 생성
        appStoreBtn.setOnClickListener(this); // click 이벤트를 위한 리스너 등록
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_side_appstore_btn:
                Intent intent = new Intent(getApplicationContext(), AppStoreActivity.class);
                //
                startActivityForResult(intent, CodeList.Request_AppStore);
        }
    }

    // AppStoreActivity에서 보낸 응답을 받음.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CodeList.Request_AppStore) {
            String result = data.getStringExtra("requestCode");
            Toast.makeText(getApplicationContext(), "응답받은 내용 : " +result, Toast.LENGTH_LONG).show();
        }
    }
}
