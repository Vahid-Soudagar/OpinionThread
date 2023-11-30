package com.example.opinionthread.database.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.opinionthread.models.Post;
import com.example.opinionthread.utils.Constants;

import java.util.List;

@Dao
public interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Post post);

    @Delete()
    void delete(Post post);

    @Query("UPDATE "+ Constants.post_table+" SET title= :title, description= :description, author= :author WHERE id=:id")
    void update(int id, String title, String description, String author);


    @Query("SELECT * FROM post ORDER BY upvotecount DESC ")
    LiveData<List<Post>> getAllPost();
}