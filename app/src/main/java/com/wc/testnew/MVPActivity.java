package com.wc.testnew;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.wc.testnew.base.Presenter;
import com.wc.testnew.base.SuperActivity;

@Presenter(MVPPresenter.class)
public class MVPActivity extends SuperActivity<MVPPresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
//        App.getWatcher(this).watch(this);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().getMsg();
            }
        });
    }

    public void show(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    public String getName() {
        return "what";
    }

    public String getNum() {
        return "the fuck";
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getWatcher(this).watch(this);
    }
}
