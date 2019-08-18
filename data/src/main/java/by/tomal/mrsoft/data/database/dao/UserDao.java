package by.tomal.mrsoft.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import by.tomal.mrsoft.data.entity.UserListResponse;
import io.reactivex.Single;

//Интерфейс Дао для бд
@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    Single<List<UserListResponse>> getUsers();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(List<UserListResponse> users);
}
