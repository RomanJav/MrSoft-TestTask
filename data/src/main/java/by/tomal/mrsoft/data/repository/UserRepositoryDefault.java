package by.tomal.mrsoft.data.repository;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.List;
import java.util.stream.Collectors;

import by.tomal.mrsoft.data.database.AppDatabase;
import by.tomal.mrsoft.data.database.dao.UserDao;
import by.tomal.mrsoft.data.entity.User;
import by.tomal.mrsoft.data.entity.UserListResponse;
import by.tomal.mrsoft.data.rest.UserService;
import io.reactivex.Single;

public class UserRepositoryDefault implements UserRepository {
    private String url;
    private UserService userService;
    private UserDao userDao;

    public UserRepositoryDefault(String url, UserService userService, Context context) {
        this.url = url;
        this.userService = userService;
        this.userDao = AppDatabase.createDatabase(context).getUserDao();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Single<List<User>> fetch() {
        return userDao.getUsers().flatMap(response -> {
            if (!response.isEmpty()) {
                return userService.requestData().map(users -> users);
            } else {
                return userService.requestData().map(users -> users);
            }
        }).map(userResponse -> userResponse.stream().map(UserListResponse::UserListResponseToEntity).collect(Collectors.toList()));
    }
}