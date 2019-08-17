package by.tomal.mrsoft.testtask.presenter;


import android.os.Build;

import androidx.annotation.RequiresApi;

import by.tomal.mrsoft.testtask.model.UseCaseProvider;
import by.tomal.mrsoft.testtask.ui.userListAdapter.UserListAdapter;

public class LoadUserList implements Load {
    private UserListAdapter userListAdapter;
    public LoadUserList(UserListAdapter userList){
        userListAdapter = userList;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void load() {
        UseCaseProvider.getUsers().subscribe(userListAdapter::setNewUsers);
    }
}
