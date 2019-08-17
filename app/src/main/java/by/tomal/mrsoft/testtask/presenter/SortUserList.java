package by.tomal.mrsoft.testtask.presenter;

import by.tomal.mrsoft.testtask.ui.userListAdapter.UserListAdapter;

public class SortUserList implements Sort {
    private UserListAdapter userListAdapter;
    public SortUserList(UserListAdapter userList){
        userListAdapter = userList;
    }

    @Override
    public void sortByLevel() {
        userListAdapter.sortUsersByLevel();
    }

    @Override
    public void sortByName() {
        userListAdapter.sortUsersByName();
    }
}
