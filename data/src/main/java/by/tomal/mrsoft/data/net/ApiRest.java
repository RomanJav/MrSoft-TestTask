package by.tomal.mrsoft.data.net;

import java.util.List;

import by.tomal.mrsoft.data.entity.UserListResponse;
import io.reactivex.Single;
import retrofit2.http.GET;

//Получение пользователей из Backendless
public interface ApiRest {
    @GET("mrsoftUsers")
    Single<List<UserListResponse>> getUsers();
}
