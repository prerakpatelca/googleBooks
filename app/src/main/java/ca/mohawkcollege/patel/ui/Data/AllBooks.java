package ca.mohawkcollege.patel.ui.Data;

public class AllBooks {

    /** GoogleBook Class array stores GoogleBook class object instances  **/
    private GoogleBook[] googleBooks;

    /**
     * @return The array of all the GoogleBooks Class Objects
     **/
    public GoogleBook[] getGoogleBooks() {
        return googleBooks;
    }

    /**
     * Setting googleBooks array
     * @param googleBooks The googleBooks Array instance
     **/
    public void setGoogleBooks(GoogleBook[] googleBooks) {
        this.googleBooks = googleBooks;
    }
}