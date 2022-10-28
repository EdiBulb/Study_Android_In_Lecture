package org.techtown.studyandroidinlecture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class SubActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub3);

        setTitle("투표 결과");

        //인텐트를 getIntent()로 받는다.
        Intent intent = getIntent();

        //넘겨받은 배열 변수를 voteResult와 ImageName 배열에 저장한다.
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");

        //넘겨 받은 그림 제목 개수만큼 텍스트뷰와 레이팅바 위젯 변수 선언한다.
        TextView tv[] = new TextView[imageName.length];
        RatingBar rbar[] = new RatingBar[imageName.length];

        //텍스트뷰와 레이팅뷰 위젯 아이디 배열 선언
        Integer tvID[] = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9};
        Integer rbarID[] = {R.id.ratingBar1,R.id.ratingBar2,R.id.ratingBar3,R.id.ratingBar4,R.id.ratingBar5,R.id.ratingBar6,R.id.ratingBar7,R.id.ratingBar8,R.id.ratingBar9};

        //위젯 아이디 배열에 위젯 대입
        for(int i=0;i<voteResult.length;i++){
            tv[i] = findViewById(tvID[i]);
            rbar[i] = findViewById(rbarID[i]);
        }

        //그림 제목과 투표수 적용하기
        for(int i=0;i<voteResult.length;i++){
            tv[i].setText(imageName[i]);
            rbar[i].setRating((float) voteResult[i]);
        }

        //종료하기
        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}