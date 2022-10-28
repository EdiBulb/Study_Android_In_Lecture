package org.techtown.studyandroidinlecture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //위젯 생성
        final RatingBar rating1, rating2, rating3;
        Button btnInc, btnDec;

        //위젯 연결
        rating1 = findViewById(R.id.ratingBar1);
        rating2 = findViewById(R.id.ratingBar2);
        rating3 = findViewById(R.id.ratingBar3);

        btnInc = findViewById(R.id.btnInc);
        btnDec = findViewById(R.id.btnDec);

        //증가버튼 클릭 이벤트
        btnInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //setRating()으로 별을 채운다. //getRating()으로 별을 가져오고, getStepSize()로 증가크기를 더한다.
                rating1.setRating(rating1.getRating()+rating1.getStepSize());
                rating2.setRating(rating2.getRating()+rating2.getStepSize());
                rating3.setRating(rating3.getRating()+rating3.getStepSize());

            }
        });

        //감소버튼 클릭 이벤트
        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rating1.setRating(rating1.getRating()- rating1.getStepSize());
                rating2.setRating(rating2.getRating()- rating2.getStepSize());
                rating3.setRating(rating3.getRating()- rating3.getStepSize());

            }
        });
    }
}