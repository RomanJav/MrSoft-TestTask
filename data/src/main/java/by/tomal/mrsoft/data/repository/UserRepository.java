package by.tomal.mrsoft.data.repository;

import java.util.List;

import by.tomal.mrsoft.data.entity.User;
import io.reactivex.Single;

public interface UserRepository {
    Single<List<User>> fetch();
}
