package model.entity;

/**
 * <h1>Film Class</h1>
 * Film is an abstract parent class.
 * <p></p>
 * This class is the base class of the Films family. Since it is abstract, instances
 * of it cannot be created. It contains the abstract method {@code view()} which
 * must be implemented by all its subclasses.
 *
 * @author carlos_cruz
 * @version 1.1
 * @since 2024
 */
public abstract class Film {
    private String title;
    private String genre;
    private String creator;
    private int duration;
    private short year;
    private boolean isViewed;

    public Film() {}

    public Film(String title, String genre, String creator, int duration) {
        this.title = title;
        this.genre = genre;
        this.creator = creator;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public boolean getIsViewed() {
        return isViewed;
    }

    public void setIsViewed(boolean isViewed) {
        this.isViewed = isViewed;
    }

    public String verifyViewed() {
        String viewed = "No";
        if (isViewed) {
            viewed = "Yes";
        }
        return viewed;
    }

    /**
     * {@code view()} Mandatory abstract method to implement.
     */
    public abstract void view();
}
