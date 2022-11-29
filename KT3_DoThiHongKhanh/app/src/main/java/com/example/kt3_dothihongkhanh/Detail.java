package com.example.kt3_dothihongkhanh;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Detail extends AppCompatActivity {
    TextView t1,ct;
    EditText vd;
    ImageButton Refresh,Luu;
    ImageButton ql;
    ListView lvFile;
    private List<vidu> arrayFile = new ArrayList<>();
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        t1=findViewById(R.id.textview);
        ct=findViewById(R.id.textView_congThuc);
        vd=findViewById(R.id.B);
        Luu=findViewById(R.id.Luu);
        Refresh=findViewById(R.id.LamMoi);
        ql=findViewById(R.id.quayve);
        t1.setText(getIntent().getExtras().getString("Name"));
        String uername =t1.getText().toString().trim();
        if (uername.equals("Hiện tại đơn")){
            ct.setText("S + V1 + O");
        }
        if (uername.equals("Hiện tại tiếp diễn")){
            ct.setText("S + BE + Ving");
        }
        if (uername.equals("Hiện tại hoàn thành")){
            ct.setText("S + HAVE/HAS + V3/Ved");
        }
        if (uername.equals("Quá khứ đơn")){
            ct.setText("S + V2/Ved");
        }
        if (uername.equals("Quá khứ tiếp diễn")){
            ct.setText("S + WAS/WERE + Ving");
        }
        if (uername.equals("Tương lai đơn")){
            ct.setText("S + WILL + V1");
        }
        AnhXa();
        adapter =new Adapter(this,R.layout.item,arrayFile);
        lvFile.setAdapter(adapter);
        Luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFile();
                vd.setText("");
            }
        });
        Refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vd.setText("");
            }
        });
        ql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void AnhXa() {
        lvFile=(ListView) findViewById(R.id.lv);
        arrayFile=new ArrayList<>();
        arrayFile.add(new vidu("Ví dụ"));
    }
    private void addFile() {
        String gtB = vd.getText().toString();

        if(TextUtils.isEmpty(gtB)){
            Toast.makeText(this, "Không Được Để Trống Các Gía Trị", Toast.LENGTH_SHORT).show();
            return;
        }
        vidu s = new vidu(gtB);
        s.setVidu(gtB);
        arrayFile.add(s);
        adapter.notifyDataSetChanged();
    }
}