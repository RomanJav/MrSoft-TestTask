package by.tomal.mrsoft.data.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "users")
public class UserListResponse {

    @SerializedName("objectId")
    @PrimaryKey
    @NonNull
    public String id = "";

    @SerializedName("name")
    @NonNull
    public String name = "";

    @SerializedName("rate")
    @NonNull
    public String rate = "";

    @SerializedName("level")
    @NonNull
    public String level = "";

    @SerializedName("class")
    @NonNull
    public String userClass = "";

    public User UserListResponseToEntity() {
        return new User(id, name, rate, level, userClass);
    }
}
