package model.entity;

import java.util.Date;

public interface IVisualizable {
    /**
     * This method captures the exact start time of viewing.
     *
     * @param dateI It is a {@code Date} object with the exact start time.
     * @return It returns the captured date and time.
     */
    Date startToSee(Date dateI);

    /**
     * This method captures the exact start and end time of viewing.
     *
     * @param dateI It is a {@code Date} object with the exact start time.
     * @param dateF It is a {@code Date} object with the exact end time.
     */
    void stopToSee(Date dateI, Date dateF);
}
