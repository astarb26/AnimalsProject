package com.example.hitprojectanimals;

import android.content.Context;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    Context context;
    private ArrayList<DataModel> dataSet;


    public CustomAdapter(ArrayList<DataModel> dataSet, BlankFragmentHeb blankFragmentOne) {
        this.dataSet = dataSet;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView textViewName;
        TextView textViewVersion;
        ImageView imageViewIcon;
        TextView description2;

        public MyViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.card_view);
            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            textViewVersion = (TextView) itemView.findViewById(R.id.textViewVersion);
            imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);

        }

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_layout, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }


    public void addCard(DataModel cardData) {
        dataSet.add(cardData);
        notifyItemInserted(dataSet.size() - 1);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int listPosition) {

        DataModel dataModel = dataSet.get(listPosition);
        CardView cardView = viewHolder.cardView;

        viewHolder.textViewName.setText(dataModel.getName());
        viewHolder.textViewVersion.setText(dataModel.getVersion());
        viewHolder.imageViewIcon.setImageResource(dataModel.getImage());


        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Bundle bundle = new Bundle();
                bundle.putString("title",dataSet.get(viewHolder.getAdapterPosition()).getName());
                bundle.putString("description",dataSet.get(viewHolder.getAdapterPosition()).getVersion());
                bundle.putInt("image",dataSet.get(viewHolder.getAdapterPosition()).getImage());
                Navigation.findNavController(view).navigate(R.id.action_blankFragmentHeb_to_blankFragmentHebTwo,bundle);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
