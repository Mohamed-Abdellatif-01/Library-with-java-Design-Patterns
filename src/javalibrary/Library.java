/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalibrary;

import java.util.ArrayList;

/**
 *
 * @author Abdellatif
 */
public class Library implements java.io.Serializable {

    private static ArrayList<Item> items = new ArrayList();
    private static ArrayList<Genre> genres = new ArrayList<Genre>();
    private static ArrayList<Author> authors = new ArrayList<Author>();
    
    private static Library instance;
    
    
    private Library(){
        Memento m = new Memento();
        instance = m.getSnapShot("resources/data.txt");
    }

    /**
     * Singleton function to keep the program connected to the database from one place 
     * Checking if the instance is null the instance equal new Library
     * @return the instance 
     */
   public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }
   

    /**
     * Adding Item to the Library 
     * @param isbn
     * @param name
     * @param pages
     * @param pub
     * @param pubdate
     * @param authors
     * @param genres
     * @return true if the item added successfully, and false if the ISBN does exist
     */
    public boolean addItem(String isbn, String name, int pages, String pub, String pubdate, String[] authors, String[] genres) {
        boolean result = false;
        int index = this.getIndex(isbn);
        if (index == -1) {
            Item i = new Item(isbn, name, pages, pub, pubdate, authors, genres);
            this.getItems().add(i);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    /**
     * Updating Item in the Library
     * @param index
     * @param isbn
     * @param name
     * @param pages
     * @param pub
     * @param pubdate
     * @param authors
     * @param genres
     * @return true if the item updated successfully, false if the ISBN does exist in any other item.
     */
    public boolean updateItem(int index, String isbn, String name, int pages, String pub, String pubdate, String[] authors, String[] genres) {
        boolean result = false;
        boolean check = false;
        for (int i = 0; i < this.getItems().size(); i++) {
            if(i != index){
                if(this.getItems().get(i).getISBN().equals(isbn)){
                    check = true;
                }
            }
        }
        if (check == false) {
            Item i = new Item(isbn, name, pages, pub, pubdate, authors, genres);
            this.getItems().set(index, i);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    /**
     * it loops throw the items and get the index of the item by ISBN
     * @param isbn
     * @return
     */
    public int getIndex(String isbn) {
        int index = -1;
        for (int i = 0; i < this.getItems().size(); i++) {
            if (this.getItems().get(i).getISBN().equals(isbn)) {
                index = i;
            }
        }

        return index;
    }

    /**
     * it take the ISBN of the Item and delete it from the library
     * @param isbn
     */
    public void deleteItem(String isbn) {
        int index = this.getIndex(isbn);
        this.getItems().remove(index);
    }

    /**
     *  Adding author to the library
     * @param name
     * @return true if the author added successfully and false if the author is already exist
     */
    public boolean AddAuthor(String name) {
        boolean result = false;
        Author a = new Author(name);

        boolean check = this.checkAuthor(name);
        if (check == true) {
            result = false;
        } else {
            this.getAuthors().add(a);
            result = true;
        }

        return result;
    }

    /**
     * to check if the author does exist or not
     * @param name
     * @return it's return true if the author does exist else returns false
     */
    public boolean checkAuthor(String name) {
        boolean result = false;
        for (int i = 0; i < this.getAuthors().size(); i++) {
            if (this.getAuthors().get(i).getName().equals(name)) {
                result = true;
            }
        }
        return result;
    }

    /**
     * it take the index of the author and delete it from the library
     * @param index
     */
    public void deleteAuthor(int index) {
        this.getAuthors().remove(index);
    }

    /**
     *  Adding genre
     * @param name
     * @return true if the genre added successfully and false if the genre is already exist
     */
    public boolean addGenre(String name) {
        boolean result = false;
        Genre a = new Genre(name);

        boolean check = this.checkGenre(name);
        if (check == true) {
            result = false;
        } else {
            this.getGenres().add(a);
            result = true;
        }

        return result;
    }

    /**
     * it take the index of the genre and delete it from the library
     * @param index
     */
    public void deleteGenre(int index) {
        this.getGenres().remove(index);
    }

    /**
     *to check if the genre does exist or not
     * @param name
     * @return it's return true if the genre does exist else returns false
     */
    public boolean checkGenre(String name) {
        boolean result = false;
        for (int i = 0; i < this.getGenres().size(); i++) {
            if (this.getGenres().get(i).getName().equals(name)) {
                result = true;
            }
        }
        return result;
    }

    /**
     * this function calls TakeSnapShot to save the library to file
     */
    public void save() {
        Memento save = new Memento();
        
        save.TakeSnapShot("resources/data.txt");
    }

    /**
     *
     * @return Items List 
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * @param aItems the items to set
     */
    public void setItems(ArrayList<Item> aItems) {
        items = aItems;
    }

    /**
     * @return the genres
     */
    public ArrayList<Genre> getGenres() {
        return genres;
    }

    /**
     * @param aGenres the genres to set
     */
    public void setGenres(ArrayList<Genre> aGenres) {
        genres = aGenres;
    }

    /**
     * @return the authors
     */
    public ArrayList<Author> getAuthors() {
        return authors;
    }

    /**
     * @param aAuthors the authors to set
     */
    public void setAuthors(ArrayList<Author> aAuthors) {
        authors = aAuthors;
    }

 

}
