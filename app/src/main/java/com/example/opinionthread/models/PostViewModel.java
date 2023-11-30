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

    public void update(int id, String title, String description, String author, String date) {
        postRepository.update(id, title, description, author, date);
    }

    public void updateUpVoteCount(int id, int upVoteCount) {
        postRepository.updateUpVoteCount(id, upVoteCount);
    }

    public void updateDownVoteCount(int id, int downVoteCount) {
        postRepository.updateDownVoteCount(id, downVoteCount);
    }

}
