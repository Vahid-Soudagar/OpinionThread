package com.example.opinionthread.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.example.opinionthread.R;
import com.example.opinionthread.databinding.FragmentAddEditPostBinding;
import com.example.opinionthread.models.Post;
import com.example.opinionthread.models.PostViewModel;
import com.example.opinionthread.utils.Functions;

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
            }
        }



        return view;
    }

    private boolean updateNote(int id) {
        String title = binding.fragmentAddEditPostTitleView.getText().toString();
        String description = binding.fragmentAddEditPostDescriptionView.getText().toString();
        String author = binding.fragmentAddEditPostAuthorView.getText().toString();
        String date = Functions.generateDate();
        boolean isValid = Functions.validateForm(getContext(), title, description, author);
        if (isValid && !date.isEmpty()) {
            postViewModel.update(id, title, description, author, date);
            return true;
        } else {
            return false;
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

    private boolean addNote() {
        String title = binding.fragmentAddEditPostTitleView.getText().toString();
        String description = binding.fragmentAddEditPostDescriptionView.getText().toString();
        String author = binding.fragmentAddEditPostAuthorView.getText().toString();
        boolean isValid = Functions.validateForm(getContext(), title, description, author);
        if (isValid) {
            int upVoteCount = 0;
            int downVoteCount = 0;
            String date = Functions.generateDate();
            newPost = new Post(title, description, author, upVoteCount, downVoteCount, date);
            postViewModel.insert(newPost);
            return true;
        }

        return false;
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
                if (addNote()) {
                    navController.navigate(R.id.action_addEditPostFragment_to_homeFragment);
                }
            }
        });

        binding.fragmentAddEditBtnSaveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (updateNote(currentPost.getId())) {
                    navController.navigate(R.id.action_addEditPostFragment_to_homeFragment);
                }
            }
        });

    }

    private void populateView(Post post) {
        binding.fragmentAddEditPostTitleView.setText(post.getTitle());
        binding.fragmentAddEditPostDescriptionView.setText(post.getDescription());
        binding.fragmentAddEditPostAuthorView.setText(post.getAuthor());
    }
}