package com.example.opinionthread.utils;

import com.example.opinionthread.models.Post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Functions {

    public static List<Post> fillData() {
        List<Post> postList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Post post = new Post(
                    i, // id
                    "Title " + i, // title
                    "Description " + i, // description
                    "Author " + i, // author
                    i * 10, // upvoteCount
                    i * 5, // downVoteCount
                    new Date() // date (you might want to set a specific date here)
            );
            postList.add(post);
        }
        return postList;
    }
}
