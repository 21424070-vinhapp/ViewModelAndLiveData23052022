package com.example.viewmodelandlivedata23052022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.viewmodelandlivedata23052022.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mBinding;
    // mText = bien tam
    String mText="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //khai bao viewBinding
        mBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        //check savedInstanceState de lay lai du lieu khi bi re-create data
        if(savedInstanceState!=null)
        {
            //lay du lieu tu bundle cua function onSaveInstanceState
            mText=savedInstanceState.getString("text");
            mBinding.textView.setText(mText);
        }

        //setOnClick tren mBinding (viewBinding)
        mBinding.btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //set Text cho textView
                mText="Xin chao";
                mBinding.textView.setText(mText);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text","Xin chao");
    }
}