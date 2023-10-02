package com.example.hocintentresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView txt1, txt2, txtKQ;
    private EditText edtNhapN;
    private Button btnUS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();

        btnUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moManHinhXuLyUocSo();
            }
        });
    }

    //bước 1 dùng startActivityForResult
    private void moManHinhXuLyUocSo() {
        Intent intent = new Intent(MainActivity.this, XuLyUocSoActivity.class);
        intent.putExtra("N", Integer.parseInt(edtNhapN.getText().toString().trim()));
        // khi bấm vô 10 chuyên qua màn hình xu ly uoc so va quay lai doan edit text se rỗng
        edtNhapN.setText("");
        startActivityForResult(intent,1);
    }

    //Bước 3 : onActivityResult(int requestCode, int resultCode, @Nullable Intent data) để nhận gia trị trả về
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2){
            ArrayList<Integer> ds = data.getIntegerArrayListExtra("DSUS");
            txtKQ.setText("");

            for (int m : ds){
                txtKQ.append(m+"\n");
                txt1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Giá trị: "+m, Toast.LENGTH_SHORT).show();
                    }
                });
                txt2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Kết quả là: "+ds, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }



    private void addControls() {
        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        txtKQ = (TextView) findViewById(R.id.txtKQ);
        edtNhapN = (EditText) findViewById(R.id.edtNhapN);
        btnUS = (Button) findViewById(R.id.btnUS);

    }
}