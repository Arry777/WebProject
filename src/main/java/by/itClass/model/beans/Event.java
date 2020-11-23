package by.itClass.model.beans;

import by.itClass.constants.Constants;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {
    private int id;
    private String title;
    private Time time;

    public Event() {
        super();
    }

    public Event(String title, String time) {
        this.title = title;
        setTime(time);
    }

    public Event(int id, String title, Time time) {
        this.id = id;
        this.title = title;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
    public void setTime(String time) {
        SimpleDateFormat format = new SimpleDateFormat(Constants.TIME_PATTERN);
        try {
            this.time = new Time(format.parse(time).getTime());
        } catch (ParseException e) {
           this.time = new Time(new Date().getTime());
            System.err.println(e.getMessage());
        }
    }
}
