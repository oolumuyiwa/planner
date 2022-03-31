package edu.vassar.cmpu203.plannerapp.view;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
//import edu.vassar.cmpu203.plannerapp.databinding.MainBinding;

public class MainView implements IMainView{
    FragmentActivity activity;
  //  MainBinding binding;

    public MainView(FragmentActivity activity){
        this.activity = activity;
    //    this.binding = MainBinding.inflate(activity.getLayoutInflater());
    }
    @Override
    public View getRootView() {
        return null;
    }

    @Override
    public void displayFragment(Fragment fragment, boolean allowBack) {

    }
}
