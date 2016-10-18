package com.pe1n.pokemon.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pe1n.pokemon.R;
import com.pe1n.pokemon.constant.MyConstant;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etUsn, etPsw;
    private Button btnLogin;
    private TextView tvRegister;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

    }

    private void initView() {

        etUsn = (EditText) findViewById(R.id.et_login_usn);
        Drawable drawable1 = getResources().getDrawable(R.mipmap.usn);
        drawable1.setBounds(0, 0, 50, 50);
        etUsn.setCompoundDrawables(drawable1, null, null, null);

        etPsw = (EditText) findViewById(R.id.et_login_psw);
        Drawable drawable2 = getResources().getDrawable(R.mipmap.psw);
        drawable2.setBounds(0, 0, 50, 50);
        etPsw.setCompoundDrawables(drawable2, null, null, null);

        btnLogin = (Button) findViewById(R.id.btn_login);
        tvRegister = (TextView) findViewById(R.id.tv_register);
        btnLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_login :

                sharedPreferences = getSharedPreferences("user",0);
                String usnInfo = sharedPreferences.getString(MyConstant.KEY_USN_INFO,null);
                String pswInfo = sharedPreferences.getString(MyConstant.KEY_PSW_INFO,null);
                String usn = etUsn.getEditableText().toString();
                String psw = etPsw.getEditableText().toString();
                if (usn.equals(usnInfo) && psw.equals(pswInfo)) {

                    Intent intent = new Intent(this,MainActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(LoginActivity.this, "用户不存在或密码错误", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.tv_register :

                Intent intent = new Intent(this,RegisterActivity.class);
                startActivityForResult(intent,MyConstant.REGISTER_REQUEST_CODE);

                break;

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MyConstant.REGISTER_REQUEST_CODE && resultCode == MyConstant.REGISTER_RESPONSE_CODE) {

            etUsn.setText(data.getStringExtra(MyConstant.KEY_USN));
            etPsw.setText(data.getStringExtra(MyConstant.KEY_PSW));

        }

    }
}
