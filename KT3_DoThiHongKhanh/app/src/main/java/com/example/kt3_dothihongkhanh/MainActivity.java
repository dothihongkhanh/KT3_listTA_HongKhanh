package com.example.kt3_dothihongkhanh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    ImageButton btnThem, btnCapNhat, btnXoa;
    ListView lv;
    ArrayList<String> arrayCourse;
    int vt = -1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnThem=(ImageButton)findViewById(R.id.buttonThem);
        btnCapNhat=(ImageButton)findViewById(R.id.buttonCapNhat);
        btnXoa=(ImageButton) findViewById(R.id.buttonXoa);
        editText=(EditText)findViewById(R.id.editText) ;
        lv = (ListView)  findViewById(R.id.lv);
        arrayCourse = new ArrayList<>();
        arrayCourse.add("Hiện tại đơn");
        arrayCourse.add("Hiện tại tiếp diễn");
        arrayCourse.add("Hiện tại hoàn thành");
        arrayCourse.add("Quá khứ đơn");
        arrayCourse.add("Quá khứ tiếp diễn");
        arrayCourse.add("Tương lai đơn");
        ArrayAdapter adapter = new ArrayAdapter <String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrayCourse
        );
        lv.setAdapter(adapter) ;
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long  l) {
                Toast.makeText(MainActivity.this, arrayCourse.get(i), Toast.LENGTH_SHORT).show();editText.setText(arrayCourse.get(i));
                lv.setSelector(R.color.purple_200);
                vt = i;
            }

        });
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayCourse.set(vt,editText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, arrayCourse.get(i), Toast.LENGTH_SHORT).show();String str=lv.getAdapter().getItem(i).toString();
                Intent intent=new Intent(getApplicationContext(),Detail.class);
                intent.putExtra("Name",str);
                startActivity(intent);
                lv.setSelector(R.color.purple_200);
                return false;
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monhoc=editText.getText().toString();
                arrayCourse.add(monhoc);
                adapter.notifyDataSetChanged();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayCourse.remove(vt);
                adapter.notifyDataSetChanged();
                editText.setText(null);
            }
        });

    }
}