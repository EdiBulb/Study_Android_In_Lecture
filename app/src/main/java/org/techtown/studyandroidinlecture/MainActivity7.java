package org.techtown.studyandroidinlecture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import java.nio.file.Path;

public class MainActivity7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));

    }
    private static class MyGraphicView extends View{
        public MyGraphicView(Context context){
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            //화면에 그려질 내용을 이곳에 코딩한다.

            //페인트 객체 생성
            Paint paint = new Paint();

            paint.setAntiAlias(true);
            //색상을 지정하기
            paint.setColor(Color.GREEN);
            canvas.drawLine(20,20,600,20,paint);

            paint.setColor(Color.BLUE);
        }


    }
}