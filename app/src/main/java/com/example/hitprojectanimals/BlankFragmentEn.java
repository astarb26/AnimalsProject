package com.example.hitprojectanimals;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class BlankFragmentEn extends Fragment {

    private ArrayList<DataModel> dataSet;

    private RecyclerView recycleView;
    private LinearLayoutManager layoutManager;
    private CustomAdapterEn adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_en, container, false);
        Button buttonHe = view.findViewById(R.id.buttonHe);
        FloatingActionButton btnOpenDialog = view.findViewById(R.id.floatingActionButton2);

        buttonHe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Navigation.findNavController(view).navigate(R.id.action_blankFragmentEn_to_blankFragmentHeb);
            }
        });


        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                CustomDialog customDialog = new CustomDialog(getContext());
                customDialog.show();
                EditText edtTitle = customDialog.findViewById(R.id.edTitle);
                EditText edDescription =customDialog.findViewById(R.id.edDec);

                Button btnAction = customDialog.findViewById(R.id.btnAction);
                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String title = "" , description = "";
                        if (!edtTitle.getText().toString().equals(""))
                        {
                            title = edtTitle.getText().toString();
                        }
                        else{
                            Toast.makeText(getContext(),"Please Enter Contact Title!",Toast.LENGTH_SHORT).show();
                        }

                        if (!edDescription.getText().toString().equals(""))
                        {
                            description =edDescription.getText().toString();
                        }
                        else{
                            Toast.makeText(getContext(),"Please Enter Contact Description!",Toast.LENGTH_SHORT).show();
                        }
                        dataSet.add(new DataModel(title, description));
                        recycleView.setAdapter(adapter);
                        customDialog.dismiss();
                    }
                });
                customDialog.show();
            }
        });

        recycleView = view.findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(getActivity()); // new GridLayoutManager
        recycleView.setLayoutManager(layoutManager);

        recycleView.setItemAnimator(new DefaultItemAnimator());

        dataSet = new ArrayList<DataModel>();


        for(int i=0 ; i<MyData.nameArray.length ; i++)
        {
            dataSet.add(new DataModel(
                    MyDataEn.nameArray[i],
                    MyDataEn.description[i],
                    MyDataEn.id_[i],
                    MyDataEn.drawableArray[i]
            ));
        }

        adapter = new CustomAdapterEn(dataSet, this);
        recycleView.setAdapter(adapter);

        return view;
    }
}