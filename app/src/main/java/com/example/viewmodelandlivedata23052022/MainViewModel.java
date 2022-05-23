package com.example.viewmodelandlivedata23052022;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private MutableLiveData<String> mutableLiveData=new MutableLiveData<>();

    public LiveData<String> getTextData()
    {
        return mutableLiveData;
    }

    public void changeText(String text)
    {
        mutableLiveData.setValue(text);
    }
}
