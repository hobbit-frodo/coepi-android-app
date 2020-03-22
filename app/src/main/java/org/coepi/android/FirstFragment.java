package org.coepi.android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;
import java.util.Vector;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        uuIDs.add("ax");
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    private static Vector<String> uuIDs = new Vector<String>();

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_new_contact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rnd = String.valueOf(Math.random());
                uuIDs.add(rnd);
                String echo = "added:"+rnd;
                Toast toast_echo = Toast.makeText( view.getContext(), echo, Toast.LENGTH_SHORT);
                toast_echo.show();
            }
        });

        view.findViewById(R.id.button_new_symptom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FrontEndAPIClient client = new FrontEndAPIClient(view.getContext());

                String echo = client.sendContactAndSymptoms("SlNPTkJMT0I6c2V2ZXJlIGZldmVyLGNvdWdoaW5n", uuIDs );
                Toast toast_echo = Toast.makeText( view.getContext(), echo, Toast.LENGTH_SHORT);
                toast_echo.show();
            }
        });

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
}
