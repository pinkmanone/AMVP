package com.wc.testnew.base;

import android.content.Context;
import android.support.v4.app.Fragment;

import java.lang.annotation.Annotation;

/**
 * Created by AndroidDeveloper on 2017/2/24/0024.
 *
 */

public class SuperFragment<P extends SuperPresenter> extends Fragment {

    private P mPresenter;

    public void attach() {
        Annotation[] as = getClass().getAnnotations();
        if (as.length > 0) {
            for (Annotation a : as) {
                if (a instanceof Presenter) {
                    Presenter p = (Presenter) a;
                    try {
                        mPresenter = (P) p.value().newInstance();
                        mPresenter.attachView(this);
                    } catch (java.lang.InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public P getPresenter(){
        return mPresenter;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        attach();
    }

    @Override
    public void onDetach() {
        getPresenter().onDestroy();
        super.onDetach();
    }
}
