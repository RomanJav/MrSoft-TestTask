package by.tomal.mrsoft.testtask.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import by.tomal.mrsoft.testtask.R;
import by.tomal.mrsoft.testtask.presenter.userListAdapter.UserListAdapter;

public class MainActivity extends AppCompatActivity {

    private UserListAdapter userListAdapter;
    private RecyclerView userList;
    private SearchView searchView;
    private Button sortUsersByButton;

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
        searchView = findViewById(R.id.search_view);
        sortUsersByButton = findViewById(R.id.sort_list_button);
    }

    private void initUserList() {
        userListAdapter = new UserListAdapter();
        userList.setHasFixedSize(true);
        userList.setLayoutManager(new LinearLayoutManager(this));
        userList.setAdapter(userListAdapter);
    }

    private void loadUsers() {

    }

    private void sortUsers() {
        
    }
}
