package com.example.anotherfirstapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    private static final String TAG = "BookActivity";
    private TextView bookName, authorName, description, pageNumber;
    private ImageView bookImage;
    private Button btnCurReading, btnWantToRead, btnAlreadyRead;
    private Book incommingBook;
    private Util util;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        overridePendingTransition(R.anim.in, R.anim.out);
        initWidgets();
        Intent intent = getIntent();
        int id = intent.getIntExtra("bookId",0);
        util = new Util();
        ArrayList<Book> books = util.getAllBooks();
        for(Book b: books){
            if(b.getId() == id){
                incommingBook = b;
                bookName.setText(b.getName());
                authorName.setText(b.getAuthor());
                description.setText(b.getDescription());
                pageNumber.setText("pages : " + b.getPages());
                Glide.with(this)
                        .asBitmap()
                        .load(b.getImageUrl())
                        .into(bookImage);
            }
        }
        btnCurReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curReadingTapped();
            }
        });
        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alreadyReadTapped();
            }
        });
        btnWantToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wantToReadTapped();
            }
        });

    }
    private void wantToReadTapped(){
        Log.d(TAG, "btnWantToReadTapped: started");

        ArrayList<Book> wantToRead = util.getWantToReadBooks();
        if(wantToRead.contains(incommingBook)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You Already Added This book to Want To read list");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setCancelable(false);
            builder.create().show();
        }else {
            ArrayList<Book> alreadyReadBooks = util.getAlreadyReadBooks();
            if(alreadyReadBooks.contains(incommingBook)){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("You Already Read this Book");
                builder.setTitle("Error");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setCancelable(false);
                builder.create().show();
            }else {
                ArrayList<Book> currentlyReadingBook = util.getCurrentlyReadingBooks();
                if(currentlyReadingBook.contains(incommingBook)){
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("You are already reading the book");
                    builder.setTitle("Error");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.setCancelable(false);
                    builder.create().show();
                }
                else{
                    util.addwantToReadBooks(incommingBook);
                    Toast.makeText(this, "The Book" + incommingBook.getName() + "is Added to your want to Read List", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    private void alreadyReadTapped(){
        Log.d(TAG, "btnAlreadyReadTapped: started");
        ArrayList<Book> alreadyReadBooks = util.getAlreadyReadBooks();
        if(alreadyReadBooks.contains(incommingBook)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You Already Added This book to Already Read list");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setCancelable(false);
            builder.create().show();
        }else{
            ArrayList<Book> currentlyReadingBook = util.getCurrentlyReadingBooks();
            if(currentlyReadingBook.contains(incommingBook)){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Have you finished reading this book ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        util.removecurrentlyReadingBook(incommingBook);
                        util.addalreadyReadBooks(incommingBook);
                        Toast.makeText(BookActivity.this, "The Book" + incommingBook.getName() + "is Added to your Already Read List", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setCancelable(false);
                builder.create().show();
            }
            else{
                util.addalreadyReadBooks(incommingBook);
                Toast.makeText(this, "The Book" + incommingBook.getName() + "is Added to your Already Read List", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void curReadingTapped(){
        Log.d(TAG, "btnCurReadingTapped: started");
        ArrayList<Book> currentlyReadingBook = util.getCurrentlyReadingBooks();
        if(currentlyReadingBook.contains(incommingBook)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You Already Added This book to Currently Reading list");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setCancelable(false);
            builder.create().show();
        } else{
            ArrayList<Book> wantToReadBooks = util.getWantToReadBooks();
            if(wantToReadBooks.contains(incommingBook)){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are you going to start reading this book ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        util.removewantToReadBooks(incommingBook);
                        util.addcurrentlyReadingBook(incommingBook);
                        Toast.makeText(BookActivity.this, "The Book" + incommingBook.getName() + "is Added to your Currently Reading Shelf", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setCancelable(false);
                builder.create().show();
            }else{
                ArrayList<Book> alredyReadyReadBook = util.getAlreadyReadBooks();
                if(alredyReadyReadBook.contains(incommingBook)){
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Do you want to read this book again ?");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            util.removealreadyReadBooks(incommingBook);
                            util.addcurrentlyReadingBook(incommingBook);
                            Toast.makeText(BookActivity.this, "The Book" + incommingBook.getName() + "is Added to your Currently Reading Shelf", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.setCancelable(false);
                    builder.create().show();
                }
                else{
                    util.addcurrentlyReadingBook(incommingBook);
                    Toast.makeText(this, "The Book" + incommingBook.getName() + "is Added to your Currently Reading Shelf", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    private void initWidgets(){
        bookName = (TextView)findViewById(R.id.bookName);
        authorName=(TextView)findViewById(R.id.authorName);
        description = (TextView)findViewById(R.id.bookDes);
        bookImage = (ImageView)findViewById(R.id.bookImage);
        pageNumber = (TextView)findViewById(R.id.bookPages);

        btnCurReading =(Button)findViewById(R.id.btnCurReading2);
        btnWantToRead = (Button)findViewById(R.id.btnWantToRead2);
        btnAlreadyRead = (Button)findViewById(R.id.btnAlreadyRead2);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.close_in, R.anim.close_out);
    }
}
