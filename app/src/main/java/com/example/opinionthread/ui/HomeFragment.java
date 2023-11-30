package com.example.opinionthread.ui;

import static androidx.navigation.fragment.FragmentKt.findNavController;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.opinionthread.R;
import com.example.opinionthread.adapters.PostAdapter;
import com.example.opinionthread.database.Database;
import com.example.opinionthread.databinding.FragmentHomeBinding;
import com.example.opinionthread.models.Post;
import com.example.opinionthread.models.PostViewModel;
import com.example.opinionthread.utils.Functions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    private FragmentHomeBinding binding;

    private List<Post> postList;
    private PostAdapter postAdapter;
    private NavController navController;
    private PostViewModel postViewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        initView();

        postViewModel = new ViewModelProvider(this).get(PostViewModel.class);
        navController = NavHostFragment.findNavController(this);

        Database database = Database.getDb(getContext());
        List<Post> list = Functions.fillData();
        for (Post post : list) {
            database.postDao().insert(post);
        }


        postViewModel.getGetAllPost().observe(getViewLifecycleOwner(), new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                Toast.makeText(getContext(), posts.size()+" ", Toast.LENGTH_SHORT).show();
                postAdapter.updatePostList(posts);
            }
        });


        return view;
    }

    private void initView() {
        binding.fragmentHomeToolbar.fragmentAddEditPost.setText(getString(R.string.all_post));
        binding.fragmentHomeToolbar.fragmentAddEditHome.setVisibility(View.GONE);

        postList = new ArrayList<>();
        postAdapter = new PostAdapter(getContext(), postList);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(postAdapter);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setItemAnimator(new DefaultItemAnimator());


        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("sourceFragment", "HomeFragment");
                navController.navigate(R.id.action_homeFragment_to_addEditPostFragment, bundle);
            }
        });
    }
}