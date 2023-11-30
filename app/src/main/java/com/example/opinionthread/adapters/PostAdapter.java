package com.example.opinionthread.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;
import com.example.opinionthread.R;
import com.example.opinionthread.models.Post;
import com.example.opinionthread.ui.AddEditPostFragment;
import com.example.opinionthread.ui.ViewPostFragment;

import java.util.List;
import java.util.Objects;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private Context context;
    private List<Post> postList;

    public PostAdapter(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post currentPost = postList.get(position);
        holder.title.setText(currentPost.getTitle());
        holder.description.setText(currentPost.getDescription());
        holder.upVoteCount.setText(String.valueOf(currentPost.getUpvoteCount()));
        holder.downVoteCount.setText(String.valueOf(currentPost.getDownVoteCount()));

        NavController navController = Navigation.findNavController((AppCompatActivity) context, R.id.navHostFragment);
        holder.btnReadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_homeFragment_to_viewPostFragment);
            }
        });

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public void updatePostList(List<Post> posts) {
        postList.clear();
        postList.addAll(posts);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title, description, upVoteCount, downVoteCount;
        ImageView upVoteImage, downVoteImage;
        Button btnReadMore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.item_post_title);
            description = (TextView) itemView.findViewById(R.id.item_post_description);
            upVoteCount = (TextView) itemView.findViewById(R.id.item_post_up_vote_txt);
            downVoteCount = (TextView) itemView.findViewById(R.id.item_post_down_vote_txt);
            upVoteImage = (ImageView) itemView.findViewById(R.id.item_post_up_vote_img);
            downVoteImage = (ImageView) itemView.findViewById(R.id.item_post_down_vote_img);
            btnReadMore = (Button) itemView.findViewById(R.id.item_post_btn_read_more);

        }
    }
}
