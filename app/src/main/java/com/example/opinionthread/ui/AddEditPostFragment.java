package com.example.opinionthread.ui;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.opinionthread.R;
import com.example.opinionthread.databinding.FragmentAddEditPostBinding;
import com.example.opinionthread.databinding.LayoutToolBarBinding;

public class AddEditPostFragment extends Fragment {

    private FragmentAddEditPostBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddEditPostBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        TextView postTextView = binding.fragmentAddEditToolBar.fragmentAddEditPost;

        // Set the text dynamically
        postTextView.setText("Your dynamic text here");

        return view;
    }
}