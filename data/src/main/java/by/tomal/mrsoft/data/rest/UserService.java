package by.tomal.mrsoft.data.rest;

import android.content.Context;

import java.util.List;

import by.tomal.mrsoft.data.database.AppDatabase;
import by.tomal.mrsoft.data.database.dao.UserDao;
import by.tomal.mrsoft.data.entity.UserListResponse;
import by.tomal.mrsoft.data.net.ApiRest;
import by.tomal.mrsoft.data.net.NetworkService;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

public class UserService {
    private UserDao userDao;
    private ApiRest api;
    private Disposable disposable = null;

    public UserService(Context context) {
        userDao = AppDatabase.createDatabase(context).getUserDao();
        api = NetworkService.getInstance().getApi();
    }

    public Single<List<UserListResponse>> requestData() {
        Single<List<UserListResponse>> userResponse = api.getUsers();
        disposable = userResponse.subscribe(response -> userDao.insert(response));
        return userResponse;
    }
}
