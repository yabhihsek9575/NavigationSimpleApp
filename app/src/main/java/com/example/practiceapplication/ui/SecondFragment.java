package com.example.practiceapplication.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.practiceapplication.R;


public class SecondFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Toast.makeText(getActivity().getApplicationContext(), "Bundle args " + getArguments().getBoolean("test_boolean"), Toast.LENGTH_SHORT).show();
       //Toast.makeText(getActivity().getApplicationContext(), "Bundle args " + FirstFragmentArgs.fromBundle(getArguments()).getTestString(), Toast.LENGTH_SHORT).show();

        //moving forward
        View.OnClickListener s = Navigation.createNavigateOnClickListener(R.id.action_secondFragment_to_thirdFragment);
        Button button = view.findViewById(R.id.button_frag2);
        button.setOnClickListener(s);

        //moving Backward
        Button button_back = view.findViewById(R.id.button_back_frag2);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final NavController navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);
                navController.navigateUp();

                navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
                    @Override
                    public void onDestinationChanged(@NonNull  NavController controller, @NonNull NavDestination destination, @Nullable  Bundle arguments) {
                        Log.d("TAG", destination.getLabel() + " ");
                    }
                });


            }
        });
    }
}