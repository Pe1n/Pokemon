package com.pe1n.pokemon.activity;

import android.content.DialogInterface;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.pe1n.pokemon.R;
import com.pe1n.pokemon.fragment.MainFragment1;
import com.pe1n.pokemon.fragment.MainFragment2;
import com.pe1n.pokemon.fragment.MainFragment3;

public class MainActivity extends AppCompatActivity {


    private AlertDialog alertDialog;
    private RadioGroup radioGroup;
    private FrameLayout frameLayout;
    private MainFragment1 mainFragment1;
    private MainFragment2 mainFragment2;
    private MainFragment3 mainFragment3;
    private FragmentManager fm;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDialog();

        initView();

    }

    private void initView() {

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null);
        fm = getSupportFragmentManager();
        mainFragment1 = new MainFragment1();
        mainFragment2 = new MainFragment2();
        mainFragment3 = new MainFragment3();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.layout_fragment,mainFragment3,"mainFragment3");
        transaction.add(R.id.layout_fragment,mainFragment2,"mainFragment2");
        transaction.add(R.id.layout_fragment,mainFragment1,"mainFragment1");
        transaction.show(mainFragment1);
        transaction.commit();
        radioGroup = (RadioGroup) findViewById(R.id.rg_tab_bottom);
        radioGroup.check(R.id.btn_home);
        frameLayout = (FrameLayout) findViewById(R.id.layout_fragment);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                FragmentTransaction transaction = fm.beginTransaction();

                switch (i) {

                    case R.id.btn_home:

                        transaction.show(mainFragment1);
                        transaction.hide(mainFragment2);
                        transaction.hide(mainFragment3);

                        break;

                    case R.id.btn_nearby:

                        transaction.show(mainFragment2);
                        transaction.hide(mainFragment1);
                        transaction.hide(mainFragment3);

                        break;

                    case R.id.btn_mine:

                        transaction.show(mainFragment3);
                        transaction.hide(mainFragment2);
                        transaction.hide(mainFragment1);

                        break;

                }

                transaction.commit();
            }
        });

    }

    private void initDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.dialog_head)
                .setMessage("真的要走了吗")
                .setCancelable(true)
                .setPositiveButton("嗯哪", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "记得有空回来看我", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                })
                .setNegativeButton("不滴", null);
        alertDialog = builder.create();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            alertDialog.show();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
