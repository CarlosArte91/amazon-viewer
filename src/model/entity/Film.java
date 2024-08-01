package model.entity;

public abstract class Film {
    private String title;
    private String gener;
    private String creator;
    private int duration;
    private short year;
    private boolean isViewed;

    public Film(String title, String gener, String creator, int duration) {
        this.title = title;
        this.gener = gener;
        this.creator = creator;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGener() {
        return gener;
    }

    public void setGener(String gener) {
        this.gener = gener;
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

    public abstract void view();
}
