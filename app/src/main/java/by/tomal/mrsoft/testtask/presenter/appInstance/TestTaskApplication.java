package by.tomal.mrsoft.testtask.presenter.appInstance;

import android.app.Application;

public class TestTaskApplication extends Application {

    private static TestTaskApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static TestTaskApplication getInstance() {
        return instance;
    }
}
