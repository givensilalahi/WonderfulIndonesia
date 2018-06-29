package com.example.gjsilalahi.recyclerviewaja;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {


    List<MainActivity.Person> persons;
    Context context;



    public static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView personName;
        TextView personContent;
        ImageView personPhoto;
        Button share;
        Button visit;
        Context context;


        public ViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cvAja);
            personName = itemView.findViewById(R.id.tvNama);
            personContent = itemView.findViewById(R.id.tvIsi);
            personPhoto = itemView.findViewById(R.id.ivAja);
            share = itemView.findViewById(R.id.btnShare);
            visit = itemView.findViewById(R.id.btnVisit);

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
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.personName.setText(persons.get(position).name);
        holder.personContent.setText(persons.get(position).content);
        holder.personPhoto.setImageResource(persons.get(position).photoId);


        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "Let's go for a trip to "
                        + String.valueOf(persons.get(position).name +
                        "\nHere is the link to the full review: " + String.valueOf(persons.get(position).share)));
                intent.setType("text/plain");
                context.startActivity(Intent.createChooser(intent, "Send To"));
            }
        });

        holder.visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(String.valueOf(persons.get(position).share)));
                context.startActivity(intent);
            }
        });
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
