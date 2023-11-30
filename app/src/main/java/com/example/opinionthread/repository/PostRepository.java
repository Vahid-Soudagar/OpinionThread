package com.example.opinionthread.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.opinionthread.database.Dao.PostDao;
import com.example.opinionthread.database.Database;
import com.example.opinionthread.models.Post;

import java.util.List;

public class PostRepository {

    private Database database;
    private LiveData<List<Post>> getAllPosts;
    private PostDao postDao;

    public PostRepository(Application application) {
        database = Database.getDb(application);
        postDao = database.postDao();
        getAllPosts = postDao.getAllPost();
    }

    public LiveData<List<Post>> getGetAllPosts() {
        return postDao.getAllPost();
    }

    public void insert(Post post) {
        postDao.insert(post);
    }

    public void delete(Post post) {
        postDao.delete(post);
    }

    public void update(Post post) {
        postDao.update(post.getId(), post.getTitle(), post.getDescription(), post.getAuthor());
    }

}
