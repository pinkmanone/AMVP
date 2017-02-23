package com.wc.testnew;

import com.wc.testnew.base.SuperModel;

/**
 * Created by AndroidDeveloper on 2017/2/22/0022.
 */
public class MVPModel extends SuperModel<MVPPresenter> {
    public void combine(String a, String b) {
        getPresenter().callback(a + " " + b);
    }
}
