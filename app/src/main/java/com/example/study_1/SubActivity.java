package com.example.study_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class SubActivity extends AppCompatActivity {

    private EditText edit_test, et_save;
    private String shared = "file";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        edit_test = findViewById(R.id.edit_test);
        et_save = (EditText)findViewById(R.id.et_save);

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        String value = sharedPreferences.getString("hong", "");   // 밑에 ondestroy에서 저장한 값을 불러오는 것이기 때문에, s1은 빈칸으로 냅둠
        et_save.setText(value);

        Intent intent = getIntent();   // Intent의 extra 정보 가져오기
        String str = intent.getStringExtra("str");   // intent정보 string으로 변환 동시에 str에 저장

        edit_test.setText(str);


    }

    @Override
    protected void onDestroy() {   // activity를 벗어났을 때
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String value = et_save.getText().toString();
        editor.putString("hong", value);   // hong이라는 이름으로 value값을 저장
        editor.commit();

    }
}