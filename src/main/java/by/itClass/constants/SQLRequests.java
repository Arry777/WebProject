package by.itClass.constants;

public final class SQLRequests {
    /* Requests */
    public static final String SELECT_USER = "select * from users where login=? and password=?";
    public static final String INSERT_USER = "insert into users(login,password,name,surname,age,email,phone) values(?,?,?,?,?,?,?)";
    public static final String SELECT_LOGIN_AND_EMAIL = "select id from users where login=? or email=?";

    public static final String SELECT_CONFERENCES = "select " +
                                                    "conferences.id, " +
                                                    "title, " +
                                                    "description, " +
                                                    "place, " +
                                                    "date, " +
                                                    "concat_ws(' ', users.surname, users.name) as author, " +
                                                    "(conferences.date < curdate()) as state " +
                                                    "from conferences " +
                                                    "left join users on conferences.idUser=users.id ";
    public static final String WHERE_HOME = "where idUser=?";
    public static final String WHERE_TODAY = "where date=curdate()";
    public static final String WHERE_TOMORROW = "where date=date_add(curdate(), interval 1 day)";
    public static final String WHERE_SOON = "where date>date_add(curdate(), interval 1 day)";
    public static final String WHERE_PASSED = "where date<curdate()";
    public static final String WHERE_ALL = "";

    public static final String SELECT_EVENTS = "select " +
                                                "events.id, " +
                                                "events.title, " +
                                                "events.time " +
                                                "from events " +
                                                "inner join conferences on events.idConf = conferences.id " +
                                                "where idConf=?";

    public static final String INSERT_CONFERENCE = "insert into conferences" +
                                                    "(description,place,date,conferences.title,idUser) " +
                                                    "values(?,?,?,?,?)";

    public static final String INSERT_EVENT = "insert into events" +
                                                "(events.time,events.title,idConf) " +
                                                "values(?,?,?)";

    public static final String DELETE_CONFERENCES = "delete from conferences where conferences.id=?";


    /* NAME COLUMNS */
    public static final String ID_COL = "id";
    public static final String LOGIN_COL = "login";
    public static final String NAME_COL = "name";
    public static final String SURNAME_COL = "surname";
    public static final String AGE_COL = "age";
    public static final String EMAIL_COL = "email";
    public static final String PHONE_COL = "phone";

    public static final String TITLE_COL = "title";
    public static final String DESCRIPTION_COL = "description";
    public static final String PLACE_COL = "place";
    public static final String DATE_COL = "date";
    public static final String TIME_COL = "time";
    public static final String AUTHOR_COL = "author";
    public static final String STATE_COL = "state";


}
