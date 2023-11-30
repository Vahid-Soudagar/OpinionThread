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

    public void update(int id, String title, String description, String author, String date) {
        postDao.update(id, title, description, author, date);
    }

    public void updateUpVoteCount(int id, int upVoteCount) {
        postDao.updateUpVoteCount(id, upVoteCount);
    }

    public void updateDownVoteCount(int id, int downVoteCount) {
        postDao.updateDownVoteCount(id, downVoteCount);
    }

}
