package com.example.gjsilalahi.recyclerviewaja;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<Person> persons;

    class Person {
        Context context;
        int name;
        int content;
        int photoId;
        int share;

        Person(Context context, int name, int content, int photoId, int share) {
            this.context = context;
            this.name = name;
            this.content = content;
            this.photoId = photoId;
            this.share = share;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvAja);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        initializeData();

        mAdapter = new RVAdapter(persons);
        recyclerView.setAdapter(mAdapter);

    }

    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person(MainActivity.this,
                R.string.judul1,
                R.string.isi1,
                R.drawable.danautoba,
                R.string.wiki_toba));
        persons.add(new Person(MainActivity.this,
                R.string.judul2,
                R.string.isi2,
                R.drawable.rajaampat,
                R.string.wiki_ampat));
        persons.add(new Person(MainActivity.this,
                R.string.judul3,
                R.string.isi3,
                R.drawable.borobudur,
                R.string.wiki_borobudur));
        persons.add(new Person(MainActivity.this,
                R.string.judul4,
                R.string.isi4,
                R.drawable.gunungbromo,
                R.string.wiki_bromo));
    }



}
