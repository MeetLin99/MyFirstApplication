package com.example.myfirstapplication;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startTestOne(View view) {
//        String testerName = ((EditText) findViewById(R.id.userNameText)).getText().toString();
//        String testerPhoneAge = ((EditText) findViewById(R.id.phoneUseTimeText)).getText().toString();
//        String testerProfession = ((EditText) findViewById(R.id.userProfession)).getText().toString();
//        int testerAge = 0;
//
//        try {
//            testerAge = Integer.parseInt(((EditText) findViewById(R.id.userAgeText)).getText().toString());
//        }catch (NumberFormatException e) {}
//
//        if(!check(testerName, testerAge, testerPhoneAge, testerProfession)) {
//            Toast.makeText(this, "输入的信息有误, 请重新输入!", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        ResDump.testerInfoInit(testerName, testerAge, testerPhoneAge, testerProfession);
        Intent intent = new Intent(this, TestOneActivity.class);
        startActivity(intent);
    }

    public void startTestOne2(View view) {
//        String testerName = ((EditText) findViewById(R.id.userNameText)).getText().toString();
//        String testerPhoneAge = ((EditText) findViewById(R.id.phoneUseTimeText)).getText().toString();
//        String testerProfession = ((EditText) findViewById(R.id.userProfession)).getText().toString();
//        int testerAge = 0;
//
//        try {
//            testerAge = Integer.parseInt(((EditText) findViewById(R.id.userAgeText)).getText().toString());
//        }catch (NumberFormatException e) {}
//
//        if(!check(testerName, testerAge, testerPhoneAge, testerProfession)) {
//            Toast.makeText(this, "输入的信息有误, 请重新输入!", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        ResDump.testerInfoInit(testerName, testerAge, testerPhoneAge, testerProfession);
        Intent intent2 = new Intent(this, TestOneActivity2.class);
        startActivity(intent2);
    }

    public void startTestOne3(View view) {
//        String testerName = ((EditText) findViewById(R.id.userNameText)).getText().toString();
//        String testerPhoneAge = ((EditText) findViewById(R.id.phoneUseTimeText)).getText().toString();
//        String testerProfession = ((EditText) findViewById(R.id.userProfession)).getText().toString();
//        int testerAge = 0;
//
//        try {
//            testerAge = Integer.parseInt(((EditText) findViewById(R.id.userAgeText)).getText().toString());
//        }catch (NumberFormatException e) {}
//
//        if(!check(testerName, testerAge, testerPhoneAge, testerProfession)) {
//            Toast.makeText(this, "输入的信息有误, 请重新输入!", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        ResDump.testerInfoInit(testerName, testerAge, testerPhoneAge, testerProfession);
        Intent intent3 = new Intent(this, TestOneActivity3.class);
        startActivity(intent3);
    }








    private boolean check(String name, int age, String phoneAge, String profession) {
        return age > 0 && name.length() > 0 && phoneAge.length() > 0 && profession.length() > 0;
    }
}