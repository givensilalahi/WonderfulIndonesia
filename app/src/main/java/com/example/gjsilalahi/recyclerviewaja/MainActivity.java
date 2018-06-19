package com.example.gjsilalahi.recyclerviewaja;

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
        int name;
        int content;
        int photoId;

        Person(int name, int content, int photoId) {
            this.name = name;
            this.content = content;
            this.photoId = photoId;
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
        persons.add(new Person(R.string.judulmia, R.string.isimia, R.drawable.mbamia));
        persons.add(new Person(R.string.judulsora, R.string.isisora, R.drawable.mbasora));
        persons.add(new Person(R.string.judulluna, R.string.isiluna, R.drawable.mbaluna));
    }



}
