package by.tomal.mrsoft.testtask.ui.userListAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.tomal.mrsoft.testtask.R;
import by.tomal.mrsoft.data.entity.User;

public class UserListAdapter extends RecyclerView.Adapter<UserListViewHolder> {

    private List<User> userList = new ArrayList<>();

    @NonNull
    @Override
    public UserListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false);
        return new UserListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListViewHolder holder, int position) {
        holder.bind(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void setNewUsers(List<User> users){
        userList = users;
        notifyDataSetChanged();
    }

    public void sortUsersByLevel(){
        Collections.sort(userList, (user1, user2) -> Integer.valueOf(user1.getLevel()).compareTo(Integer.valueOf(user2.getLevel())));
        notifyDataSetChanged();
    }

    public void sortUsersByName(){
        Collections.sort(userList, (user1, user2) -> user1.getName().compareToIgnoreCase(user2.getName()));
        notifyDataSetChanged();
    }
}
