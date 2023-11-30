package com.example.opinionthread.models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.opinionthread.repository.PostRepository;

import java.util.List;

public class PostViewModel extends AndroidViewModel {

    private PostRepository postRepository;
    private LiveData<List<Post>> getAllPost;
    public PostViewModel(@NonNull Application application) {
        super(application);

        postRepository = new PostRepository(application);
        getAllPost = postRepository.getGetAllPosts();
    }

    public void insert(Post post) {
        postRepository.insert(post);
    }

    public LiveData<List<Post>> getGetAllPost() {
        return getAllPost;
    }

    public void delete(Post post) {
        postRepository.delete(post);
    }

    public void update(Post post) {
        postRepository.update(post);
    }
}
