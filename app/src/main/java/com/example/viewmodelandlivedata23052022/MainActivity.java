package com.example.viewmodelandlivedata23052022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.viewmodelandlivedata23052022.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mBinding;
    MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //khai bao viewBinding
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        //owner chinh la lifecycle cua thang mainActivity
        mMainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        //lay du lieu tu ViewModel
        mMainViewModel.getTextData().observe(this, new Observer<String>() {
            //khi lifecycle co su thay doi thi se chay vao ham onChanged
            @Override
            public void onChanged(String s) {
                mBinding.textView.setText(s);
            }
        });

        //setOnClick tren mBinding (viewBinding)
        mBinding.btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMainViewModel.changeText("Xin chao");
            }
        });
    }

}