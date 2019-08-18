package by.tomal.mrsoft.testtask.presenter;

import by.tomal.mrsoft.testtask.ui.userListAdapter.UserListAdapter;

import static by.tomal.mrsoft.testtask.presenter.appInstance.StaticResources.SORT_BY_LEVEL;
import static by.tomal.mrsoft.testtask.presenter.appInstance.StaticResources.SORT_BY_NAME;

public class SortUserList implements Sort {
    private UserListAdapter userListAdapter;

    public SortUserList(UserListAdapter userList) {
        userListAdapter = userList;
    }

    @Override
    public void sort(String sortBy) {
        if (sortBy.equals(SORT_BY_LEVEL))
            userListAdapter.sortUsersByLevel();
        else if (sortBy.equals(SORT_BY_NAME))
            userListAdapter.sortUsersByName();
    }

}
