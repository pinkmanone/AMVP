package com.wc.testnew.base;

public class SuperModel<P extends SuperPresenter> {

    private P mPresenter;

    public void attachPresenter(P p) {
        this.mPresenter = p;
    }

    public P getPresenter() {
        return mPresenter;
    }

    public void destroy() {
        mPresenter = null;
    }
}
