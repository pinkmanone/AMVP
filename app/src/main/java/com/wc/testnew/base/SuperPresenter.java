package com.wc.testnew.base;

import java.lang.annotation.Annotation;
import java.lang.ref.WeakReference;


public class SuperPresenter<V, M extends SuperModel> {

    private WeakReference<V> vWeakReference;

    private M model;

    public SuperPresenter() {
        attach();
    }

    public void attachView(V view) {
        vWeakReference = new WeakReference<>(view);
    }

    public void attach() {
        Annotation[] as = getClass().getAnnotations();
        if (as.length > 0) {
            for (Annotation a : as) {
                if (a instanceof Model) {
                    Model m = (Model) a;
                    try {
                        model = (M) m.value().newInstance();
                        model.attachPresenter(this);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public V getView() {
        return vWeakReference.get();
    }

    public M getModel() {
        return model;
    }

    public void onDestroy() {
        model.destroy();
        vWeakReference.clear();
        vWeakReference = null;
    }

}
