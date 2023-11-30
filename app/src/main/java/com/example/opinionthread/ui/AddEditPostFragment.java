package com.example.opinionthread.ui;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.opinionthread.R;
import com.example.opinionthread.databinding.FragmentAddEditPostBinding;
import com.example.opinionthread.databinding.LayoutToolBarBinding;
import com.example.opinionthread.models.Post;
import com.example.opinionthread.models.PostViewModel;
import com.example.opinionthread.utils.Functions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddEditPostFragment extends Fragment {

    private FragmentAddEditPostBinding binding;
    private NavController navController;
    private boolean isEdit = false;

    private Post newPost;
    private Post currentPost;
    private PostViewModel postViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddEditPostBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        navController = NavHostFragment.findNavController(this);
        postViewModel = new ViewModelProvider(this).get(PostViewModel.class);
        initView();

        Bundle bundle = getArguments();
        if (bundle != null) {
            String sourceFragment = bundle.getString("sourceFragment");
            if ("HomeFragment".equals(sourceFragment)) {
                isEdit = false;
            } else if ("ViewPostFragment".equals(sourceFragment)) {
                isEdit = true;
                changeToEdit(isEdit);
                currentPost = (Post) bundle.getSerializable("post");
                populateView(currentPost);
                Toast.makeText(getContext(), currentPost.getTitle(), Toast.LENGTH_SHORT).show();
            }
        }



        return view;
    }

    private void updateNote(int id) {
        String title = binding.fragmentAddEditPostTitleView.getText().toString();
        String description = binding.fragmentAddEditPostDescriptionView.getText().toString();
        String author = binding.fragmentAddEditPostAuthorView.getText().toString();
        String date = Functions.generateDate();

        if (!title.isEmpty() && !description.isEmpty() && !author.isEmpty()) {
            postViewModel.update(id, title, description, author, date);
        }
    }

    private void changeToEdit(boolean value) {
        if (value) {
            binding.fragmentAddEditBtnSubmit.setVisibility(View.GONE);
            binding.fragmentAddEditBtnSaveChanges.setVisibility(View.VISIBLE);
        } else {
            binding.fragmentAddEditBtnSubmit.setVisibility(View.VISIBLE);
            binding.fragmentAddEditBtnSaveChanges.setVisibility(View.GONE);
        }
    }

    private void addNote() {
        String title = binding.fragmentAddEditPostTitleView.getText().toString();
        String description = binding.fragmentAddEditPostDescriptionView.getText().toString();
        String author = binding.fragmentAddEditPostAuthorView.getText().toString();

        if (!title.isEmpty() && !description.isEmpty() && !author.isEmpty()) {
            int upVoteCount = 0;
            int downVotwCount = 0;
            String date = Functions.generateDate();
            newPost = new Post(title, description, author, upVoteCount, downVotwCount, date);
            postViewModel.insert(newPost);
        }
    }
    private void initView() {
        TextView postTextView = binding.fragmentAddEditToolBar.fragmentAddEditPost;
        postTextView.setText(getString(R.string.create_post));
        binding.fragmentAddEditToolBar.fragmentAddEditHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_addEditPostFragment_to_homeFragment);
            }
        });

        binding.fragmentAddEditBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNote();
                navController.navigate(R.id.action_addEditPostFragment_to_homeFragment);
            }
        });

        binding.fragmentAddEditBtnSaveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNote(currentPost.getId());
                navController.navigate(R.id.action_addEditPostFragment_to_homeFragment);
            }
        });

    }

    private void populateView(Post post) {
        binding.fragmentAddEditPostTitleView.setText(post.getTitle());
        binding.fragmentAddEditPostDescriptionView.setText(post.getDescription());
        binding.fragmentAddEditPostAuthorView.setText(post.getAuthor());
    }
}