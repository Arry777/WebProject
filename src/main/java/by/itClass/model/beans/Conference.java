package by.itClass.model.beans;

import by.itClass.constants.Constants;
import com.google.gson.Gson;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Conference {
    private int id;
    private String title;
    private String description;
    private String place;
    private Date date;
    private String author;
    private boolean state;
    private List<Event> events;

    public Conference() {
        super();
        events = new ArrayList<>();
    }

    public Conference(String title, String description, String place, String date) {
        this();
        setTitle(title);
        this.description = description;
        setPlace(place);
        setDate(date);
    }

    public Conference(int id, String title, String description, String place, Date date, int state, String author, List<Event> events) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.place = place;
        this.date = date;
        this.author = author;
        setState(state);
        this.events = events;

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
        if(Objects.isNull(title) || title.equals("") || title.length() == 0) {
            this.title = "DEFAULT";
        } else {
            this.title = title;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        if (Objects.isNull(place) || place.equals("") || place.length() == 0) {
            this.place = "DEFAULT";
        } else {
            this.place = place;
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_PATTERN);
        try {
            this.date = new Date(format.parse(date).getTime());
        } catch (ParseException e) {
            this.date = new Date(new java.util.Date().getTime());
            System.err.println(e.getMessage());
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public void setAuthor(String name, String surname) {
        this.author = String.join(" ", surname, name);
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setState(int state) {
        this.state = state == 0;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(String[] titles, String[] times) {
        if (Objects.nonNull(titles)) {
            for (int i = 0; i < titles.length; i++) {
                events.add(new Event(titles[i], times[i]));
            }
        }
    }

    public String toJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
