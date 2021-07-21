package com.run4urlyfe;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.run4urlyfe.DAO.Profile;

public class AppViMo extends ViewModel {

    private final MutableLiveData<Profile> profile = new MutableLiveData<>();

    public LiveData<Profile> getProfile() {
        return profile;
    }

    public void setProfile(Profile pProfile) {
        profile.setValue(pProfile);
    }
}
