package by.tomal.mrsoft.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import by.tomal.mrsoft.data.database.dao.UserDao;
import by.tomal.mrsoft.data.entity.UserListResponse;

//Создание базы данных Room
@Database(entities = {UserListResponse.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DB_NAME = "users.db";

    public static AppDatabase createDatabase(final Context context) {
        return Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME).build();
    }

    public abstract UserDao getUserDao();
}
