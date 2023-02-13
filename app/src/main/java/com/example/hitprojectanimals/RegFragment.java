package com.example.hitprojectanimals;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.hitprojectanimals.activitys.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegFragment newInstance(String param1, String param2) {
        RegFragment fragment = new RegFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_reg, container, false);
        EditText TextEmail = view.findViewById(R.id.editTextTextEmailAddress2);
        EditText TextPass = view.findViewById(R.id.editTextTextPassword3);
        EditText TextId = view.findViewById(R.id.editTextid);
        EditText TextPhone = view.findViewById(R.id.editTextphone);
        EditText TextAddress = view.findViewById(R.id.editTextaddress);
        Button buttonReg = view.findViewById(R.id.button2);

        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.funcButtonRegLoginPage( TextEmail, TextPass,view);
                mainActivity.write( TextEmail, TextPhone,TextId,TextAddress);
            }
        });


        return view;
    }
}