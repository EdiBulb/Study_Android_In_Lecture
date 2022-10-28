package org.techtown.studyandroidinlecture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/*실습 2 - 명화 선호도 투표 앱 만들기*/
public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        setTitle("캐릭터 선호도 투표");

        final int voteCount[] = new int[9];
        for(int i=0;i<9;i++){
            voteCount[i] = 0;
        }

        ImageView image[] = new ImageView[9];
        Integer imageId[] = {R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9, };

        //이미지 이름
        final String imgName[] = {"피카츄","파이리","이상해씨","메타몽","잠만보","뮤","뮤츠","잉어킹","고라파덕"};


        for(int i=0;i<imageId.length;i++){
            final int index;
            index = i;

            //위젯 연결
            image[index] = findViewById(imageId[index]);

            //이미지 뷰 클릭 이벤트
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(), imgName[index] + ": 총 " + voteCount[index] + " 표", Toast.LENGTH_SHORT).show();
                }
            });
        }

        //종료 버튼 위젯 연결
        Button btnFinish = findViewById(R.id.btnResult);

        //종료 버튼 클릭 이벤트
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this, SubActivity3.class);
                intent.putExtra("VoteCount", voteCount);//수를 넘기기
                intent.putExtra("ImageName",imgName);//이름 넘기기
                startActivity(intent);
            }
        });
    }
}