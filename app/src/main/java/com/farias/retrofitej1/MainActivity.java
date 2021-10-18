package com.farias.retrofitej1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.farias.retrofitej1.modelo.Post;

public class MainActivity extends AppCompatActivity {
    private MaintActivityViewModel mv;
    private TextView tvMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMostrar=findViewById(R.id.tvMostrar);
        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MaintActivityViewModel.class);
        mv.getMutableLiveData().observe(this, new Observer<Post>() {
            @Override
            public void onChanged(Post post) {
                tvMostrar.setText(post.getBody());
            }
        });

        mv.leerPost();

    }

}