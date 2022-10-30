package org.techtown.studyandroidinlecture;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

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
//        builder.setTitle("버튼 추가 예제").setMessage("선택하세요..");

        builder.setTitle("리스트 추가 예제");

        //커스텀 다이얼로그 만들기
        View dialogView = getLayoutInflater().inflate(R.layout.activity_alertdialog_sub, null); // 커스텀한 레이아웃을 View 객체로 가여조기
        final EditText nameEditText = dialogView.findViewById(R.id.name);
        final EditText NicknameEditText = dialogView.findViewById(R.id.nickname);

        builder.setView(dialogView);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String name = "이름은 : " + nameEditText.getText().toString();
                String nickname = "별명은 : " + NicknameEditText.getText().toString();

                Toast.makeText(AlertDialogActivity.this, name + "\n" + nickname, Toast.LENGTH_LONG).show();
            }
        });

//        //다이얼로그 설정 - setItems()함수 : 리스트 추가
//        builder.setItems(R.array.LAN, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                String[] items = getResources().getStringArray(R.array.LAN);
//                Toast.makeText(AlertDialogActivity.this, items[i], Toast.LENGTH_LONG).show();
//            }
//        });

//        //다이얼로그 설정 - setMultiChociItems()함수 : 체크박스
//        final ArrayList<String> selectedItems = new ArrayList<>(); // 클릭한 데이터를 넣을 배열
//        final String[] items = getResources().getStringArray(R.array.LAN);
//
//        builder.setMultiChoiceItems(R.array.LAN, null, new DialogInterface.OnMultiChoiceClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i, boolean isChecked) {
//                if(isChecked == true){
//                    selectedItems.add(items[i]);
//                }
//                else{
//                    selectedItems.remove(i);
//                }
//            }
//        });

//        //다이얼로그 설정 - 단일 선택 목록 추가 - 라디오 버튼
//        final String[] items = getResources().getStringArray(R.array.LAN);
//        final ArrayList<String> selectedItem = new ArrayList<>();
//        selectedItem.add(items[0]);
//
//        builder.setSingleChoiceItems(R.array.LAN, 0, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                selectedItem.clear();
//                selectedItem.add(items[i]);
//            }
//        });
//
//        //OK 버튼 - 라디오 버튼이랑 연결
//        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast toast = Toast.makeText(AlertDialogActivity.this, "선택된 항목 : " + selectedItem.get(0), Toast.LENGTH_LONG);
//                toast.setGravity(Gravity.CENTER, 0,0);
//                toast.show();
//            }
//        });
        
//        //다이얼로그 설정 - OK 버튼 만들기
//        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int pos) {
//                String selectedItemsString = "";
//
//                //클릭된 데이터 개수만큼 반복
//                for(int i=0;i<selectedItems.size();i++){
//                    selectedItemsString = selectedItemsString + "," + selectedItems.get(i);
//                }
//                Toast toast =  Toast.makeText(AlertDialogActivity.this,"선택된 항목은 :" + selectedItemsString, Toast.LENGTH_SHORT);
//                toast.setGravity(Gravity.CENTER,0,0);
//                toast.show();
//            }
//        });
//
//        //다이얼로그 설정 - Cancel 버튼 만들기
//        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(AlertDialogActivity.this, "Cancel Click", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        builder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(AlertDialogActivity.this, "Neutral Click",Toast.LENGTH_SHORT).show();
//            }
//        });

        
        //설정된 buildr를 토대로 다이얼로그 객체 생성
        AlertDialog alertDialog = builder.create();

        //다이얼로그 출력
        alertDialog.show();
    }
}