package by.tomal.mrsoft.testtask.presenter.userListAdapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import by.tomal.mrsoft.testtask.R;
import by.tomal.mrsoft.testtask.presenter.entity.User;

class UserListViewHolder extends RecyclerView.ViewHolder {
    private TextView userName;
    private TextView userRate;
    private TextView userLevel;
    private TextView userClass;

    UserListViewHolder(@NonNull View itemView) {
        super(itemView);
        userName = itemView.findViewById(R.id.user_name);
        userRate = itemView.findViewById(R.id.user_rate);
        userLevel = itemView.findViewById(R.id.user_level);
        userClass = itemView.findViewById(R.id.user_class);
    }

    void bind(User user){
        userName.setText(user.getName());
        userRate.setText(user.getRate());
        userLevel.setText(user.getLevel());
        userClass.setText(user.getUserClass());
    }
}
