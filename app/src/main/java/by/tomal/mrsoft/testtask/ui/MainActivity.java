package by.tomal.mrsoft.testtask.ui;


import android.app.SearchManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import by.tomal.mrsoft.testtask.R;
import by.tomal.mrsoft.testtask.presenter.LoadUserList;
import by.tomal.mrsoft.testtask.presenter.SortUserList;
import by.tomal.mrsoft.testtask.ui.userListAdapter.UserListAdapter;

public class MainActivity extends AppCompatActivity {

    private UserListAdapter userListAdapter = new UserListAdapter();
    private RecyclerView userList;
    private Button sortUsersByButton;
    private Toolbar toolbar;
    private RadioButton checkSortByName;
    private RadioButton checkSortByLevel;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayout();
        initUserList();
        loadUsers();
        sortUsersByButton.setOnClickListener(view -> sortUsers());
    }

    private void initLayout() {
        userList = findViewById(R.id.user_list);
        sortUsersByButton = findViewById(R.id.sort_list_button);
        toolbar = findViewById(R.id.search_view);
        checkSortByName = findViewById(R.id.sort_by_name);
        checkSortByLevel = findViewById(R.id.sort_by_level);
    }

    private void initUserList() {
        userList.setHasFixedSize(true);
        userList.setLayoutManager(new LinearLayoutManager(this));
        userList.setAdapter(userListAdapter);
        setSupportActionBar(toolbar);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void loadUsers() {
        LoadUserList users = new LoadUserList(userListAdapter);
        users.load();
    }

    private void sortUsers() {
        SortUserList users = new SortUserList(userListAdapter);
        if (checkSortByName.isChecked())
            users.sortByName();
        else if (checkSortByLevel.isChecked())
            users.sortByLevel();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                userListAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                userListAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
