package org.techtown.studyandroidinlecture;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.accessibility.AccessibilityViewCommand;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*양방향 액티비티 연습*/
public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        setTitle("메인 액티비티");

        //버튼 설정
        Button btnNewActivity = findViewById(R.id.btnNewActivity);

        //버튼 클릭이벤트
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //위젯 설정
                EditText edtNum1 = findViewById(R.id.edtNum1);
                EditText edtNum2 = findViewById(R.id.edtNum2);

                //인텐트 생성
                Intent intent = new Intent(MainActivity4.this, SecondActivity4.class);

                //인텐트에 데이터 넣기
                intent.putExtra("Num1",Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2",Integer.parseInt(edtNum2.getText().toString()));

                //화면 전환
                startActivityForResult(intent,0);




            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            int hap = data.getIntExtra("Hap", 0);
            Toast.makeText(MainActivity4.this, "합계 :" + hap, Toast.LENGTH_SHORT).show();
        }
    }
}