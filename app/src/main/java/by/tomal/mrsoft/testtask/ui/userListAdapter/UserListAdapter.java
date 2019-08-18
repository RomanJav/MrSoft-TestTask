package by.tomal.mrsoft.testtask.ui.userListAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.tomal.mrsoft.testtask.R;
import by.tomal.mrsoft.data.entity.User;

public class UserListAdapter extends RecyclerView.Adapter<UserListViewHolder> implements Filterable {

    private List<User> userList = new ArrayList<>();
    private List<User> userListPreFiltered = new ArrayList<>();

    @NonNull
    @Override
    public UserListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false);
        view.setOnClickListener(sort -> sortUsersByRate());
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
        userListPreFiltered = users;
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
    private void sortUsersByRate(){
        Collections.sort(userList, (user1, user2) -> Integer.valueOf(user1.getRate()).compareTo(Integer.valueOf(user2.getRate())));
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        return new Filter(){
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    userList = userListPreFiltered;
                } else {
                    List<User> filteredList = new ArrayList<>();
                    for (User user : userList) {
                        if (user.getName().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(user);
                        }
                    }
                    userList = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = userList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                userList = (ArrayList<User>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
