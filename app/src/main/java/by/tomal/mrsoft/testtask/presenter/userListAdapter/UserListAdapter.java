package by.tomal.mrsoft.testtask.presenter.userListAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import by.tomal.mrsoft.testtask.R;
import by.tomal.mrsoft.testtask.presenter.entity.User;

public class UserListAdapter extends RecyclerView.Adapter<UserListViewHolder> {

    private ArrayList<User> userList = new ArrayList<>();

    @Override
    public UserListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false);
        return new UserListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserListViewHolder holder, int position) {
        holder.bind(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
