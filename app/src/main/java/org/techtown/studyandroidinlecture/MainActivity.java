package org.techtown.studyandroidinlecture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //버튼 위젯 연결
        Button btnNewActivity = findViewById(R.id.btnNewActivity);
        
        //버튼 클릭이벤트
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트 생성
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                //새로운 액티비티 화면을 출력하기
                startActivity(intent);
            }
        });
    }
}