package com.example.opinionthread.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.opinionthread.R;
import com.example.opinionthread.models.Post;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
                    "12th Nov 2001" // date (you might want to set a specific date here)
            );
            postList.add(post);
        }
        return postList;
    }

    public static void showPopUp(Context context, View.OnClickListener onClickListener) {
        View dialog = LayoutInflater.from(context).inflate(R.layout.layout_dialog, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(dialog);

        LinearLayout editButton = dialog.findViewById(R.id.item_post_btn_edit_view);
        LinearLayout deleteButton = dialog.findViewById(R.id.item_post_btn_delete_view);

        AlertDialog alertDialog = builder.create();

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null) {
                    onClickListener.onClick(v);
                }
                alertDialog.dismiss();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the "Cancel" button click
                // Dismiss the dialog
                alertDialog.dismiss();
            }
        });

        // Show the dialog
        alertDialog.show();
    }

    public static String generateDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
        String date = dateFormat.format(new Date());
        return date;
    }

    public static boolean validateForm(Context context, String title, String description, String author) {
        if (title.isEmpty()) {
            Toast.makeText(context, "Please Enter Post Title", Toast.LENGTH_LONG).show();
            return false;
        }
        if (description.isEmpty()) {
            Toast.makeText(context, "Please Enter Post Description", Toast.LENGTH_LONG).show();
            return false;
        }
        if (author.isEmpty()) {
            Toast.makeText(context, "Please Enter Author Name", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }
}
