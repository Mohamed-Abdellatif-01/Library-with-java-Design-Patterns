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
public class Item implements java.io.Serializable {

    private String Name;
    private String ISBN;
    private int NumOfPages;
    private String Publisher;
    private String PubDate;
    private String[] Authors;
    private String[] Genres;

    public Item(String isbn, String name, int pages, String pub, String pubdate, String[] authors, String[] genres){
        this.ISBN = isbn;
        this.Name = name;
        this.NumOfPages = pages;
        this.Publisher = pub;
        this.PubDate = pubdate;
        this.Authors = authors;
        this.Genres = genres;
    }
    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the ISBN
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * @param ISBN the ISBN to set
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * @return the NumOfPages
     */
    public int getNumOfPages() {
        return NumOfPages;
    }

    /**
     * @param NumOfPages the NumOfPages to set
     */
    public void setNumOfPages(int NumOfPages) {
        this.NumOfPages = NumOfPages;
    }

    /**
     * @return the Publisher
     */
    public String getPublisher() {
        return Publisher;
    }

    /**
     * @param Publisher the Publisher to set
     */
    public void setPublisher(String Publisher) {
        this.Publisher = Publisher;
    }

    /**
     * @return the PubDate
     */
    public String getPubDate() {
        return PubDate;
    }

    /**
     * @param PubDate the PubDate to set
     */
    public void setPubDate(String PubDate) {
        this.PubDate = PubDate;
    }

    /**
     * @return the Authors
     */
    public String[] getAuthors() {
        return Authors;
    }

    /**
     * @param Authors the Authors to set
     */
    public void setAuthors(String[] Authors) {
        this.Authors = Authors;
    }

    /**
     * @return the Genres
     */
    public String[] getGenres() {
        return Genres;
    }

    /**
     * @param Genres the Genres to set
     */
    public void setGenres(String[] Genres) {
        this.Genres = Genres;
    }

}
