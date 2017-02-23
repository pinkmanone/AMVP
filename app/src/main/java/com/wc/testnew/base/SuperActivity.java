package com.wc.testnew.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.lang.annotation.Annotation;


public class SuperActivity<P extends SuperPresenter> extends AppCompatActivity {
    private P presenter;

    public void attach() {
        Annotation[] as = getClass().getAnnotations();
        if (as.length > 0) {
            for (Annotation a : as) {
                if (a instanceof Presenter) {
                    Presenter p = (Presenter) a;
                    try {
                        presenter = (P) p.value().newInstance();
                        presenter.attachView(this);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public P getPresenter() {
        return presenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        attach();
    }

    @Override
    protected void onDestroy() {
        getPresenter().onDestroy();
        super.onDestroy();

    }
}
