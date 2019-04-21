package com.hh.jikbanglistviewex;

import android.databinding.DataBindingUtil;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hh.jikbanglistviewex.databinding.ActivityJikBangDetailBinding;

import datas.JikBang;

public class JikBangDetail extends AppCompatActivity {
    JikBang jikBang;
    ActivityJikBangDetailBinding act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_jik_bang_detail);
        act = DataBindingUtil.setContentView(this, R.layout.activity_jik_bang_detail);



         jikBang = (JikBang) getIntent().getSerializableExtra("방정보");

        act.bojeng.setText(String.format("%d", jikBang.bojeng));
        act.paymentMonth.setText(String.format("%d", jikBang.payment_month));
        act.addr.setText(String.format("%s", jikBang.addr));
        act.descriong.setText(String.format("%s", jikBang.descriong));




    }
}
