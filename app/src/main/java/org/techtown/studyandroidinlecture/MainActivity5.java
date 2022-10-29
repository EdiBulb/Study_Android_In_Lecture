package org.techtown.studyandroidinlecture;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

/*암시적 인텐트*/
public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        setTitle("암시적 인텐트 예제");

        //버튼 위젯 연결하기
        Button btnDial = findViewById(R.id.btnDial);
        Button btnWeb = findViewById(R.id.btnWeb);
        Button btnGoogle = findViewById(R.id.btnGoogle);
        Button btnSearch = findViewById(R.id.btnSearch);
        Button btnSms = findViewById(R.id.btnSms);
        Button btnPhoto = findViewById(R.id.btnPhoto);

        //전화 버튼 이벤트
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:01012345678");
                //전화 걸기 창 열기함
                Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intent);
            }
        });

        //웹사이트 버튼 이벤트
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://www.hanbit.co.kr");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        //구글 맵 버튼 이벤트
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://maps.google.co.kr/maps?q=" + 37.559133 + "," + 126.927824 + "&z" + 15);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });

        //구글 서치 버튼
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "안드로이드");
                startActivity(intent);
            }
        });

        //문자 보내기
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body", "안녕하세요?");
                intent.setData(Uri.parse("smsto:" + Uri.encode("010-1234-4567")));
                startActivity(intent);
            }
        });

        //카메라 사진 찍기
        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });

    }
}











