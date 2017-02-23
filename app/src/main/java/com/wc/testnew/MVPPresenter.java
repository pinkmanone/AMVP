package com.wc.testnew;

import com.wc.testnew.base.Model;
import com.wc.testnew.base.SuperPresenter;

/**
 * Created by AndroidDeveloper on 2017/2/22/0022.
 */
@Model(MVPModel.class)
public class MVPPresenter extends SuperPresenter<MVPActivity, MVPModel> {

    public void getMsg() {
        getModel().combine(getView().getName(), getView().getNum());
    }

    public void callback(String s) {
        getView().show(s);
    }
}
