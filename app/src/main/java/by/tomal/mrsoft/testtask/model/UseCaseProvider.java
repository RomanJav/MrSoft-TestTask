package by.tomal.mrsoft.testtask.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.List;

import by.tomal.mrsoft.data.entity.User;
import by.tomal.mrsoft.data.repository.UserRepositoryDefault;
import by.tomal.mrsoft.data.rest.UserService;
import by.tomal.mrsoft.testtask.presenter.appInstance.TestTaskApplication;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UseCaseProvider {
    //Получение пользователей из бд по умолчанию
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static Single<List<User>> getUsers() {
        return new UserRepositoryDefault("", new UserService(
                TestTaskApplication.getInstance().getBaseContext()),
                TestTaskApplication.getInstance().getBaseContext()).fetch().subscribeOn(getWorkScheduler()).observeOn(getPostScheduler());
    }


    private static Scheduler getWorkScheduler() {
        return Schedulers.io();
    }

    private static Scheduler getPostScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
