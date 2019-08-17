package by.tomal.mrsoft.testtask.ui;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import by.tomal.mrsoft.testtask.R;
import by.tomal.mrsoft.testtask.presenter.LoadUserList;
import by.tomal.mrsoft.testtask.ui.userListAdapter.UserListAdapter;

public class MainActivity extends AppCompatActivity {

    private UserListAdapter userListAdapter = new UserListAdapter();
    private RecyclerView userList;
    private Button sortUsersByButton;

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
    }

    private void initUserList() {
        userList.setHasFixedSize(true);
        userList.setLayoutManager(new LinearLayoutManager(this));
        userList.setAdapter(userListAdapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void loadUsers() {
        LoadUserList users = new LoadUserList(userListAdapter);
        users.load();
    }

    private void sortUsers() {

    }
}
