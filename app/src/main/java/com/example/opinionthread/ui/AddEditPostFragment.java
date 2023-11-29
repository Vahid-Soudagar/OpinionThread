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
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.opinionthread.R;
import com.example.opinionthread.databinding.FragmentAddEditPostBinding;
import com.example.opinionthread.databinding.LayoutToolBarBinding;

public class AddEditPostFragment extends Fragment {

    private FragmentAddEditPostBinding binding;
    private NavController navController;
    private boolean isEdit = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddEditPostBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        navController = NavHostFragment.findNavController(this);

        TextView postTextView = binding.fragmentAddEditToolBar.fragmentAddEditPost;
        postTextView.setText(getString(R.string.create_post));

        Bundle bundle = getArguments();
        if (bundle != null) {
            String sourceFragment = bundle.getString("sourceFragment");
            if ("HomeFragment".equals(sourceFragment)) {
                isEdit = false;
            } else if ("ViewPostFragment".equals(sourceFragment)) {
                // Handle the case when coming from ViewPostFragment
                isEdit = true;
            }
        }


        binding.fragmentAddEditToolBar.fragmentAddEditHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_addEditPostFragment_to_homeFragment);
            }
        });


        changeToEdit(isEdit);

        return view;
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
}