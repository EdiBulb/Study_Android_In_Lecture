package org.techtown.studyandroidinlecture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second4);

        setTitle("Second 액티비티");

        //MainActivity4 에서 인텐드를 받는다.
        Intent inIntent = getIntent();
        //Num1 Num2값을 받아서 더한다.
        final int hapValue = inIntent.getIntExtra("Num1",0) + inIntent.getIntExtra("Num2",0);

        //버튼 위젯 연결
        Button btnReturn = findViewById(R.id.btnReturn);

        //버튼 클릭 이벤트
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outIntent = new Intent(SecondActivity4.this, MainActivity4.class);
                //Hap 값을 보낸다.
                outIntent.putExtra("Hap", hapValue);

                //setReslut() 로 메인 액티비티에 값을 돌려준다. -> 메인 액티비티의 onActivityResult()가 실행된다.
                setResult(RESULT_OK, outIntent);
                //현재 액티비티를 닫는다.
                finish();
            }
        });
    }
}