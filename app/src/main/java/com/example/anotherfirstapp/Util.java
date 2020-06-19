package com.example.anotherfirstapp;

import java.util.ArrayList;

public class Util {
    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> alreadyReadBooks;

    private static int id = 0;

    public Util(){
        if(allBooks == null){
            allBooks = new ArrayList<>();
            initAllBooks();
        }
        if(currentlyReadingBooks == null){
            currentlyReadingBooks = new ArrayList<>();
        }
        if(wantToReadBooks == null){
            wantToReadBooks = new ArrayList<>();
        }
        if(alreadyReadBooks == null){
            alreadyReadBooks = new ArrayList<>();
        }
    }
    private static void initAllBooks(){
        String name;
        String author;
        int pages;
        String imageUrl;
        String description;

        id++;
        name="Advanced Physics";
        author="Alibaba";
        pages=1350;
        imageUrl="https://images-na.ssl-images-amazon.com/images/I/516TMQSwtzL._SX351_BO1,204,203,200_.jpg";
        description="Physics";
        allBooks.add(new Book(id,name,author,pages,imageUrl,description));

        id++;
        name="Chemistry Concepts & Problems";
        author="Amazon";
        pages=1120;
        imageUrl="https://images-na.ssl-images-amazon.com/images/I/51HPfOJ4E2L._SX404_BO1,204,203,200_.jpg";
        description="Chemistry";
        allBooks.add(new Book(id,name,author,pages,imageUrl,description));

        id++;
        name="Basic Machines And How They Work";
        author="Amazon";
        pages=1560;
        imageUrl="https://images-na.ssl-images-amazon.com/images/I/51g%2BYZjv5-L._SX349_BO1,204,203,200_.jpg";
        description="Mechanical";
        allBooks.add(new Book(id,name,author,pages,imageUrl,description));

        id++;
        name="Make Electronics 2nd Edition";
        author="Roton Kumar";
        pages=1100;
        imageUrl="https://images-na.ssl-images-amazon.com/images/I/51j48HH1P9L._SX402_BO1,204,203,200_.jpg";
        description="Electronics";
        allBooks.add(new Book(id,name,author,pages,imageUrl,description));

        id++;
        name="When We Believed in Mermaids";
        author="Ranjan Kumar PK";
        pages=1100;
        imageUrl="https://images-na.ssl-images-amazon.com/images/I/41DPq03IAOL._SX331_BO1,204,203,200_.jpg";
        description="Fantasy";
        allBooks.add(new Book(id,name,author,pages,imageUrl,description));

        id++;
        name="The Tuscan Child";
        author="Chandra Kumar";
        pages=1100;
        imageUrl="https://images-na.ssl-images-amazon.com/images/I/51CzocBKb1L._SX331_BO1,204,203,200_.jpg";
        description="Funny";
        allBooks.add(new Book(id,name,author,pages,imageUrl,description));

        id++;
        name="Where the Forest Meets the Stars";
        author="Jane Healey";
        pages=1100;
        imageUrl="https://images-na.ssl-images-amazon.com/images/I/51sZRlFOe6L._SX331_BO1,204,203,200_.jpg";
        description="Story";
        allBooks.add(new Book(id,name,author,pages,imageUrl,description));


    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public boolean addcurrentlyReadingBook(Book book){
        return currentlyReadingBooks.add(book);
    }
    public boolean addwantToReadBooks(Book book){
        return wantToReadBooks.add(book);
    }
    public boolean addalreadyReadBooks(Book book){
        return alreadyReadBooks.add(book);
    }
    public boolean removecurrentlyReadingBook(Book book){
        return currentlyReadingBooks.remove(book);
    }
    public boolean removewantToReadBooks(Book book){
        return wantToReadBooks.remove(book);
    }
    public boolean removealreadyReadBooks(Book book){
        return alreadyReadBooks.remove(book);
    }
}
