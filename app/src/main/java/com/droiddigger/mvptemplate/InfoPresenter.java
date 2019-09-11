package com.droiddigger.mvptemplate;

import android.content.Context;

public class InfoPresenter implements InfoContract.presenter {
    Context mContext;
    InfoContract.view mView;

    public InfoPresenter(Context context, InfoContract.view mView) {
        this.mView = mView;
        this.mContext = context;
    }

    @Override
    public void initPresenter() {
        mView.initViews();
    }

    @Override
    public void acquireData(User user) {
        if (!user.getEmail().isEmpty() && !user.getFullName().isEmpty()) {
            mView.showData(user.getEmail(), user.getFullName());
        }
    }
}
