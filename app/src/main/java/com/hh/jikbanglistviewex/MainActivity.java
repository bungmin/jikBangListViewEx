package com.hh.jikbanglistviewex;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Toast;

import com.hh.jikbanglistviewex.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import adaptors.JikBangAdapter;
import datas.JikBang;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding act;
    List<JikBang> jikBangList = new ArrayList<JikBang>();
    JikBangAdapter mAdapter;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        act = DataBindingUtil.setContentView(this, R.layout.activity_main);
        fillBang();

        mAdapter = new JikBangAdapter(MainActivity.this, jikBangList);
        act.listJikBang.setAdapter(mAdapter);


        act.listJikBang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Toast.makeText()
                Intent intent = new Intent(MainActivity.this, JikBangDetail.class);

                JikBang selectedJikBang = jikBangList.get(position);

                intent.putExtra("방정보", selectedJikBang);
                startActivity(intent);



            }
        });

        act.listJikBang.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                jikBangList.remove(position);
                mAdapter.notifyDataSetChanged();


                return true;
            }
        });

        act.BangAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tempAddr = "임시주소";
                String tempDescription = "임시설명";

                tempAddr += Integer.toString(++i);
                tempDescription += Integer.toString(i);

                jikBangList.add(new JikBang(i, i, i, tempAddr, tempDescription));



                mAdapter.notifyDataSetChanged();

            }
        });


    }

    void fillBang(){
        jikBangList.add(new JikBang(100, 13, 2, "경상북도 구미시 송정동 분리형 원룸","(풀옵션 초대박원룸)"));
        jikBangList.add(new JikBang(100, 15, 3, "경상북도 구미시 신평동 분리형 원룸","(풀옵션 초대박원룸)"));
        jikBangList.add(new JikBang(100, 13, 3, "경상북도 구미시 원평동 분리형 원룸","(풀옵션 초대박원룸)"));
        jikBangList.add(new JikBang(100, 13, 1, "경상북도 구미시 형곡동 분리형 원룸","(풀옵션 초대박원룸)"));
        jikBangList.add(new JikBang(100, 15, 5, "경상북도 구미시 송정동 분리형 원룸","(풀옵션 초대박원룸)"));
        jikBangList.add(new JikBang(100, 11, 4, "경상북도 구미시 구미동 분리형 원룸","(풀옵션 초대박원룸)"));

    }
}
