package com.droiddigger.mvptemplate;

/*Contract that will be followed by the View & Presenter*/
public interface InfoContract {
    interface view {
        void initViews();

        void showData(String email, String username);

    }

    interface presenter {
        void initPresenter();

        void acquireData(User user);
    }

}
