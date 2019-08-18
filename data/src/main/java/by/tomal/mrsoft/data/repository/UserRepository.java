package by.tomal.mrsoft.data.repository;

import java.util.List;

import by.tomal.mrsoft.data.entity.User;
import io.reactivex.Single;

//Общий интерфейс для получения данных
public interface UserRepository {
    Single<List<User>> fetch();
}
