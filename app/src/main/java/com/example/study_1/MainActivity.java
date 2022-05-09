package com.example.study_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edit_id;
    private Button bt_change, bt_move, bt_web;
    private ImageView img_test;
    private String str;
    private ListView list_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_id = findViewById(R.id.edit_id);
        bt_change = findViewById(R.id.bt_change);
        bt_move = findViewById(R.id.bt_move);
        bt_web = findViewById(R.id.bt_web);
        img_test = findViewById(R.id.img_test);
        list_id = findViewById(R.id.list_id);


        //   listview 세팅 코드(리스트 및 어댑터 생성)
        List<String> data = new ArrayList<>();
        ArrayAdapter<String>adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        list_id.setAdapter(adapter);

        data.add("one heavy");
        data.add("two heavy");
        adapter.notifyDataSetChanged();   // 위 입력한 리스트 정보를 저장하는 코드
        //   listview 세팅 코드

        bt_change.setOnClickListener(new View.OnClickListener() { // 클릭했을 때 코드 작성
            @Override
            public void onClick(View view) {
                edit_id.setText("SeongSan");
            }
        });

        bt_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str = edit_id.getText().toString();   // str 선언 후 문구 저장 및 string 변환
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("str", str);   // Intent 실행 동시에 str 정보 저장
                startActivity(intent);
            }
        });

        bt_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WebActivity.class);
                startActivity(intent);
            }
        });

        img_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "기본 이미지입니다.", Toast.LENGTH_SHORT).show();
            }
        });



    }


}