package com.example.anotherfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

    private RecyclerView bookrecyclerView;
    private static final String tag = "All Book Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);
        overridePendingTransition(R.anim.in, R.anim.out);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Log.d(tag, "Oncreate Started !");

        bookrecyclerView = (RecyclerView) findViewById(R.id.recycleView);

        BookRecycleAdapter adapter = new BookRecycleAdapter(this);
        bookrecyclerView.setAdapter(adapter);
        bookrecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        ArrayList<Book> books = new ArrayList<>();
        /*books.add(new Book("Advanced Physics", "Alibaba", 1350,
                "https://images-na.ssl-images-amazon.com/images/I/516TMQSwtzL._SX351_BO1,204,203,200_.jpg",
                "Physics"));
        books.add(new Book("Chemistry Concepts & Problems", "Amazon", 1120,
                "https://images-na.ssl-images-amazon.com/images/I/51HPfOJ4E2L._SX404_BO1,204,203,200_.jpg",
                "Chemistry"));
        books.add(new Book("Basic Machines And How They Work", "Amazon", 1560,
                "https://images-na.ssl-images-amazon.com/images/I/51g%2BYZjv5-L._SX349_BO1,204,203,200_.jpg",
                "Mechanical"));
        books.add(new Book("Make Electronics 2nd Edition", "Amazon", 1100,
                "https://images-na.ssl-images-amazon.com/images/I/51j48HH1P9L._SX402_BO1,204,203,200_.jpg",
                "Electronics"));*/
        Util util = new Util();
        books = util.getAllBooks();
        adapter.setBooks(books);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.close_in, R.anim.close_out);
    }
}
