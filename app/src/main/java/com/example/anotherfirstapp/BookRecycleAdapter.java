package com.example.anotherfirstapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookRecycleAdapter extends RecyclerView.Adapter<BookRecycleAdapter.ViewHolder>{

    private static final String TAG = "BooksRecViewAdapter";
    private Context context;
    private String type = "";
    Util util;

    public BookRecycleAdapter(Context context) {
        this.context = context;
        util = new Util();
    }

    private ArrayList<Book> books = new ArrayList<>();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: called");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book_recview, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        holder.bookName.setText(books.get(position).getName());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BookActivity.class);
                intent.putExtra("bookId",books.get(position).getId());
                context.startActivity(intent);
            }
        });
        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                final Book book = books.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Deleting " + book.getName())
                        .setMessage("Are you sure you want to delete " + book.getName() + "?")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                switch (type){
                    case "want to read":
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(util.removewantToReadBooks(books.get(position))){
                                    Toast.makeText(context, book.getName() + "has successfully deleted",Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                            }
                        }).create().show();
                        break;
                    case "already read":
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(util.removealreadyReadBooks(books.get(position))){
                                    Toast.makeText(context, book.getName() + "has successfully deleted",Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                            }
                        }).create().show();
                        break;
                    case "currently read":
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(util.removecurrentlyReadingBook(books.get(position))){
                                    Toast.makeText(context, book.getName() + "has successfully deleted",Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                            }
                        }).create().show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        Glide.with(context)
                .asBitmap()
                .load(books.get(position).getImageUrl())
                .into(holder.bookImage);
    }
    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView bookImage;
        private TextView bookName;
        private CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            bookImage = (ImageView)itemView.findViewById(R.id.bookImage);
            bookName = (TextView) itemView.findViewById(R.id.bookNameText);
            cardView = (CardView) itemView.findViewById(R.id.bookCard);
        }
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public void setType(String type) {
        this.type = type;
    }
}
