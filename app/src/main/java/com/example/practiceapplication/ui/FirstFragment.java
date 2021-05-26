package com.example.practiceapplication.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.practiceapplication.R;


public class FirstFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        final Bundle bundle = new Bundle();
        bundle.putBoolean("test_boolean", true);

        View.OnClickListener s = Navigation.createNavigateOnClickListener(R.id.action_firstFragment_to_secondFragment);
        Button button = view.findViewById(R.id.button_frag1);
        button.setOnClickListener(s);


        //or we can use below code

        //1 st way

        /*final NavController navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_firstFragment_to_secondFragment);
            }
        });*/

        // 2 nd way


        /*final NavDirections navDirections = FirstFragmentDirections.actionFirstFragmentToSecondFragment();
        final NavController navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(navDirections);
            }
        });*/

    }
}