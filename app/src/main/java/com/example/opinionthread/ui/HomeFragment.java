package com.example.opinionthread.ui;

import static androidx.navigation.fragment.FragmentKt.findNavController;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.opinionthread.R;
import com.example.opinionthread.adapters.PostAdapter;
import com.example.opinionthread.databinding.FragmentHomeBinding;
import com.example.opinionthread.models.Post;
import com.example.opinionthread.utils.Functions;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    private FragmentHomeBinding binding;

    private List<Post> postList;
    private PostAdapter postAdapter;
    private NavController navController;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        navController = NavHostFragment.findNavController(this);
        postList = new ArrayList<>();
        postList.addAll(Functions.fillData());
        postAdapter = new PostAdapter(getContext(), postList);

        binding.fragmentHomeToolbar.fragmentAddEditPost.setText(getString(R.string.all_post));
        binding.fragmentHomeToolbar.fragmentAddEditHome.setVisibility(View.GONE);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(postAdapter);
        postAdapter.notifyDataSetChanged();


        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("sourceFragment", "HomeFragment");
                navController.navigate(R.id.action_homeFragment_to_addEditPostFragment, bundle);
            }
        });
        return view;
    }
}