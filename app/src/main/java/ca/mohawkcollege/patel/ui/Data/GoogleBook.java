package ca.mohawkcollege.patel.ui.Data;

public class GoogleBook {

    /** Stores Title of the Book **/
    private String title;

    /** Stores Authors of the Book  **/
    private String authors;

    /** Stores Publisher of the Book **/
    private String publisher;

    /** Stores Published Date of the Book **/
    private String publishedDate;

    /** Stores Description of the Book **/
    private String description;

    /** Stores Thumbnail Image URL of the Book **/
    private String thumbnail;

    /**
     * @return The title of the Book
     **/
    public String getTitle() {
        return title;
    }

    /**
     * Setting the title of the Book
     * @param title Title of the Book     **/
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return Authors of the Book
     **/
    public String getAuthors() {
        return authors;
    }

    /**
     * Setting the authors of the Book
     * @param authors Authors of the Book     **/
    public void setAuthors(String authors) {
        this.authors = authors;
    }

    /**
     * @return Publisher of the Book
     **/
    public String getPublisher() {
        return publisher;
    }

    /**
     * Setting Publisher of the Book
     * @param publisher Publisher of the Book
     **/
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * @return Published Date of the Book
     **/
    public String getPublishedDate() {
        return publishedDate;
    }

    /**
     * Setting Published Date of the Book
     * @param publishedDate Published Date of the Book
     **/
    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    /**
     * @return Description of the Book
     **/
    public String getDescription() {
        return description;
    }

    /**
     * Setting the description of the Book
     * @param description Description of the Book
     **/
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return Thumbnail of the Book
     **/
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * Setting thumbnail of the Book
     * @param thumbnail Thumbnail of the Book
     **/
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
