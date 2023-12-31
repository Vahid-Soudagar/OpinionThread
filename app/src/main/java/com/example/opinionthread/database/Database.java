package com.example.opinionthread.database;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.opinionthread.database.Dao.PostDao;
import com.example.opinionthread.models.Post;

import java.util.List;


@androidx.room.Database(entities = Post.class, exportSchema = false, version = 1)
public abstract class Database extends RoomDatabase {

    private static final String DB_NAME = "postdb";
    private static Database instance;
    public abstract PostDao postDao();

    public static synchronized Database getDb(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, Database.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }

}
