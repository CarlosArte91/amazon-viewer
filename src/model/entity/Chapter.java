package model.entity;

import java.util.ArrayList;

/**
 * It inherits from {@link Movie}
 * @see Film
 */
public class Chapter extends Movie {
    private int id;
    private int sessionNumber;
    private Serie serie;

    public Chapter(
            String title,
            String gener,
            String creator,
            int duration,
            short year,
            int sessionNumber,
            Serie serie
    ) {
        super(title, gener, creator, duration, year);
        this.setSessionNumber(sessionNumber);
        this.setSerie(serie);
    }

    public int getSessionNumber() {
        return sessionNumber;
    }

    public void setSessionNumber(int sessionNumber) {
        this.sessionNumber = sessionNumber;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "\n:: SERIE ::" +
                "\nTitle: " + getSerie().getTitle() +
                "\n:: CHAPTER ::" +
                "\nTitle: " + getTitle() +
                "\nYear: " + getYear() +
                "\nCreator: " + getCreator() +
                "\nDuration: " + getDuration();
    }

    @Override
    public void view() {
        super.view();

        ArrayList<Chapter> chapters = getSerie().getChapters();
        int viewedCounter = 0;

        for (Chapter chapter : chapters) {
            if (chapter.getIsViewed()) {
                viewedCounter++;
            }
        }

        if (viewedCounter == chapters.size()) {
            getSerie().setIsViewed(true);
        }
    }

    public static ArrayList<Chapter> makeList(Serie serie) {
        ArrayList<Chapter> chapters = new ArrayList<>();
        Chapter chapter;

        for (int i = 0; i < 5; i++) {
            int item = i + 1;

            chapter = new Chapter(
                    "Chapter " + item,
                    "Gener " + item,
                    "Creator " + item,
                    45,
                    (short) (2015 + item),
                    item,
                    serie
            );

            chapters.add(chapter);
        }
        return chapters;
    }
}
