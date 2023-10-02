package com.example.hocintentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class XuLyUocSoActivity extends AppCompatActivity {
    private TextView txt1 , txtKQ;
    private Button btnKQ;
    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xu_ly_uoc_so);
        addControls();

//        intent = getIntent();
//        int s = intent.getIntExtra("N",0);
//        txtKQ.setText(""+s);

        btnKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyKQ(); // bước 2
            }
        });
    }

    //Bước 2 : trả kết quả về main activity
    private void xuLyKQ() {
        int n = Integer.parseInt(txtKQ.getText().toString());
        ArrayList<Integer> dsUS = new ArrayList<>();
        for (int i = 1; i<=n; i++){
            if (n%i==0){
                dsUS.add(i);
            }
        }
        intent.putExtra("DSUS",dsUS);
        setResult(2,intent); //chú ý
        finish(); //chú ý
    }

    private void addControls() {
        //Bước 2: xử lý ước số mình dùng hàm getIntent
        intent = getIntent(); // chú ý
        int s = intent.getIntExtra("N",0);
        txt1 = (TextView) findViewById(R.id.txt1);
        txtKQ = (TextView) findViewById(R.id.txtKQ);
        txtKQ.setText(""+s);
        btnKQ = (Button) findViewById(R.id.btnKQ);
    }
}