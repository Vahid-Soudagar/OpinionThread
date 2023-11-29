package com.example.opinionthread.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.opinionthread.R;
import com.example.opinionthread.databinding.FragmentViewPostBinding;
import com.example.opinionthread.utils.Functions;

public class ViewPostFragment extends Fragment {

    public ViewPostFragment() {
        // Required empty public constructor
    }

    private FragmentViewPostBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentViewPostBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        navController = NavHostFragment.findNavController(this);

        binding.fragmentViewPostToolbar.fragmentAddEditPost.setText(getString(R.string.view_post));


//        edit
        binding.itemPostBtnEditView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("sourceFragment", "ViewPostFragment");
                navController.navigate(R.id.action_viewPostFragment_to_addEditPostFragment, bundle);
            }
        });

        binding.itemPostBtnDeleteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Functions.showPopUp(getContext(), new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(), "Deleted successfully", Toast.LENGTH_SHORT).show();
                        navController.navigate(R.id.action_viewPostFragment_to_homeFragment2);
                    }
                });
            }
        });

        return view;
    }
}