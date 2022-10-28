package org.techtown.studyandroidinlecture;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        //버튼 연결
        Button btnReturn = findViewById(R.id.btnReturn);

        //버튼 클릭 이벤트
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();//현재 액티비티를 끝낸다.
            }
        });
    }
}
