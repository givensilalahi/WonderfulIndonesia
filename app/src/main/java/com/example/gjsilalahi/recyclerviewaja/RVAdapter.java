package com.example.gjsilalahi.recyclerviewaja;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {


    List<MainActivity.Person> persons;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView personName;
        TextView personContent;
        ImageView personPhoto;


        public ViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cvAja);
            personName = itemView.findViewById(R.id.tvNama);
            personContent = itemView.findViewById(R.id.tvIsi);
            personPhoto = itemView.findViewById(R.id.ivAja);

        }
    }


    public RVAdapter (List<MainActivity.Person> persons){
        this.persons = persons;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_view_aja, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.personName.setText(persons.get(position).name);
        holder.personContent.setText(persons.get(position).content);
        holder.personPhoto.setImageResource(persons.get(position).photoId);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    //tambahan
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


}
