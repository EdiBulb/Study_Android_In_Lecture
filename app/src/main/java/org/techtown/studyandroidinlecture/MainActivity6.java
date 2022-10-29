package org.techtown.studyandroidinlecture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*액티비티 생명주기*/
public class MainActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        setTitle("액티비티 테스트 예제");

        //로그 찍기
        android.util.Log.i("액티비티 테스트", "onCreate()");

        //전화 걸기 버튼
        Button btnDial = findViewById(R.id.btnDial);

        //전화 걸기 버튼 클릭 이벤트
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:01089669815");
                Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intent);
            }
        });

        //끝내기 버튼
        Button btnFinish = findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        android.util.Log.i("액티비티 테스트", "onCreate()");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        android.util.Log.i("액티비티 테스트", "onPause()");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        android.util.Log.i("액티비티 테스트", "onRestart()");
        super.onRestart();
    }

    @Override
    protected void onPostResume() {
        android.util.Log.i("액티비티 테스트", "onResume()");
        super.onPostResume();
    }

    @Override
    protected void onStart() {
        android.util.Log.i("액티비티 테스트", "onStart()");
        super.onStart();
    }

    @Override
    protected void onStop() {
        android.util.Log.i("액티비티 테스트", "onStop()");
        super.onStop();
    }
}