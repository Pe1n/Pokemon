package com.pe1n.pokemon.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.pe1n.pokemon.R;
import com.pe1n.pokemon.constant.MyConstant;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etUsn, etPsw, etCheck;
    private Button btnCommit;
    private ImageView ivBack;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();

    }

    private void initView() {

        etUsn = (EditText) findViewById(R.id.et_register_usn);
        Drawable drawable1 = getResources().getDrawable(R.mipmap.usn);
        drawable1.setBounds(0, 0, 50, 50);
        etUsn.setCompoundDrawables(drawable1, null, null, null);

        etPsw = (EditText) findViewById(R.id.et_register_psw);
        Drawable drawable2 = getResources().getDrawable(R.mipmap.psw);
        drawable2.setBounds(0, 0, 50, 50);
        etPsw.setCompoundDrawables(drawable2, null, null, null);

        etCheck = (EditText) findViewById(R.id.et_register_check);
        Drawable drawable3 = getResources().getDrawable(R.mipmap.check);
        drawable3.setBounds(0, 0, 50, 50);
        etCheck.setCompoundDrawables(drawable3, null, null, null);

        btnCommit = (Button) findViewById(R.id.btn_commit);
        ivBack = (ImageView) findViewById(R.id.iv_back);
        btnCommit.setOnClickListener(this);
        ivBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_commit:

                String usn = etUsn.getEditableText().toString();
                String psw = etPsw.getEditableText().toString();
                String check = etCheck.getEditableText().toString();

                if (!TextUtils.isEmpty(usn) && !TextUtils.isEmpty(psw) && !TextUtils.isEmpty(check) && psw.equals(check)) {
                    sharedPreferences = getSharedPreferences("user",0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(MyConstant.KEY_USN_INFO,usn);
                    editor.putString(MyConstant.KEY_PSW_INFO,psw);
                    editor.commit();

                    Intent intent = new Intent(this,LoginActivity.class);
                    intent.putExtra(MyConstant.KEY_USN,usn);
                    intent.putExtra(MyConstant.KEY_PSW,psw);
                    setResult(MyConstant.REGISTER_RESPONSE_CODE,intent);
                    finish();

                } else {
                    Toast.makeText(RegisterActivity.this, "您输入的信息有误,请重新核对", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.iv_back:
                    finish();
                break;

        }

    }
}
