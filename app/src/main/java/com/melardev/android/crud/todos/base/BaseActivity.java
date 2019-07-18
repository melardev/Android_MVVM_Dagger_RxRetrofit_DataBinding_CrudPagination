package com.melardev.android.crud.todos.base;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import dagger.android.AndroidInjection;

public abstract class BaseActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        initProgressDialog();
    }

    private void initProgressDialog() {
        progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);

        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setGravity(Gravity.CENTER);

        relativeLayout.addView(progressBar);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        );

        progressBar.setVisibility(View.VISIBLE);

        this.addContentView(relativeLayout, params);
    }

    protected void handleErrorResponse(String[] errors) {
        hideLoader();

        // Build.VERSION.SDK_INT >= Build.VERSION_CODES.O:
        // You could also use String.join(",", getTodoOperation.fullMessages)

        if (errors != null && errors.length > 0)
            Toast.makeText(this, TextUtils.join("\n", errors), Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Unknown Error TodoDetailsActivity", Toast.LENGTH_SHORT).show();
    }

    protected void hideLoader() {
        progressBar.setVisibility(View.GONE);
    }

    protected void displayLoader() {
        progressBar.setVisibility(View.VISIBLE);
    }
}
