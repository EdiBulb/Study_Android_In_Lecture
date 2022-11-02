package org.techtown.studyandroidinlecture;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class Project8_1 extends AppCompatActivity {

    //위젯 선언
    DatePicker dp;
    EditText edtDiary;
    Button btnWrite;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project81);

        setTitle("간단 일기장");

        //위젯 연결결
        dp = findViewById(R.id.datePicker1);
        edtDiary = findViewById(R.id.edtDiaty);
        btnWrite = findViewById(R.id.btnWrite);

        //Calender클래스를 이용해 현재 날짜의 연/월/일 구한다.
        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.YEAR);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);

        Log.d("Project8_1", cYear +","+ cMonth +","+ cDay);

        //데이트피커 초기화 및 날짜 변경시 이벤트처리
        dp.init(cYear,cMonth, cDay, new DatePicker.OnDateChangedListener(){
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                fileName = Integer.toString(year) + "_" + Integer.toString(monthOfYear + 1) + "_" + Integer.toString(dayOfMonth)+".txt";
                String str = readDiary(fileName);
                edtDiary.setText(str);
                btnWrite.setEnabled(true);
            }
        });

        //버튼 클릭 이벤트
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    FileOutputStream outFs = openFileOutput(fileName, Context.MODE_PRIVATE);
                    String str = edtDiary.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(Project8_1.this, fileName + " 이 저장됨", Toast.LENGTH_SHORT).show();
                }catch (IOException e){

                }
            }
        });
    }
    //파일을 읽어 일기 내용을 반환하는 메소드
    String readDiary(String fName){
        String diaryStr = null;
        FileInputStream inFs;

        try{
            inFs = openFileInput(fName);
            byte[] txt = new byte[500];
            inFs.read(txt);
            inFs.close();
            diaryStr = (new String(txt)).trim();
            btnWrite.setText("수정하기");
        } catch (IOException e){
            edtDiary.setHint("일기 없음");
            btnWrite.setText("새로 서장");
        }
        return diaryStr;
    }
}
