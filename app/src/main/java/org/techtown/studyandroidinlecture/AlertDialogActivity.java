package org.techtown.studyandroidinlecture;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AlertDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
    }

    //버튼 1에 클릭시 실행되는 메소드
    public void OnClickHandler(View view)
    {
        //빌더 객체 생성 : AlertDialog에 여러 정보를 세팅하려면 먼저 AlertDialog.Builder 객체를 생성해야한다.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //빌더 타이틀 설정 및 메세지 설정
        builder.setTitle("버튼 추가 예제").setMessage("선택하세요..");
        
        //다이얼로그 설정 - OK 버튼 만들기
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertDialogActivity.this,"OK Click", Toast.LENGTH_SHORT).show();
            }
        });

        //
        
        //설정된 buildr를 토대로 다이얼로그 객체 생성
        AlertDialog alertDialog = builder.create();

        //다이얼로그 출력
        alertDialog.show();
    }
}