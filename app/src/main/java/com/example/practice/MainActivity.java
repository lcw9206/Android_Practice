package com.example.practice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.practice.appstore.AppStore;
import com.example.practice.appstore.AppStoreActivity;
import com.example.practice.common.CodeList;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

// 복수의 activity를 호출하는 Activity라는 가정하에 OnclickListener 상속
// 상속을 통해 하나의 onClick 메서드 안에서 모든 클릭 이벤트 처리가능
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<AppStore> appStoreList = new ArrayList<AppStore>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // activity_main.xml 정의

        appStoreList = getAppStoreList();

        AdapterView adapter = 

        Button appStoreBtn = findViewById(R.id.main_side_appstore_btn); // main_side의 appstore_btn 객체 생성
        appStoreBtn.setOnClickListener(this); // click 이벤트를 위한 리스너 등록
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_side_appstore_btn:
                Intent intent = new Intent(getApplicationContext(), AppStoreActivity.class);
                // 화면별 분기를 위한 startActivityForResult 메서드 사용
                startActivityForResult(intent, CodeList.Request_AppStore);
        }
    }

    // startActivityForResult 메서드로 보낸 RequestCode AppStoreActivity에서 보낸 응답을 받음.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CodeList.Request_AppStore) {
            String result = data.getStringExtra("requestCode");
            Toast.makeText(getApplicationContext(), "응답받은 내용 : " +result, Toast.LENGTH_LONG).show();
        }
    }

    //
    public ArrayList getAppStoreList() {

        ArrayList<AppStore> appStoreList = new ArrayList<AppStore>();

        AppStore app1 = new AppStore("G-TALK", "하나은행", "2020-04-01");
        AppStore app2 = new AppStore("Hana EZ", "하나은행", "2020-04-02");
        AppStore app3 = new AppStore("Hana Digital Campus", "하나은행", "2020-04-03");
        AppStore app4 = new AppStore("하나 타운홀 Talk", "하나은행", "2020-04-04");
        AppStore app5 = new AppStore("하나 원큐 심플", "하나은행", "2020-04-05");

        appStoreList.add(app1);
        appStoreList.add(app2);
        appStoreList.add(app3);
        appStoreList.add(app4);
        appStoreList.add(app5);

        return appStoreList;
    }
}
