package by.itClass.constants;

public final class Constants {
    /* DB */
    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost/web?serverTimezone=Europe/Minsk";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "";

    /* APP CONSTANTS */
    public static final String MESSAGE = "message";
    public static final String USER = "user";
    public static final String CONFERENCES = "conferences";
    public static final String CONFERENCE = "conference";

    public static final String TODAY_SECTION = "today";

    public static final int ID_DEFAULT = -1;

    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String TIME_PATTERN = "HH:mm";

    /* FILES */
    public static final String DB_PROPERTY = "/META-INF/db.properties";

    /* RESOURCES */
    public static final String INDEX_JSP = "/index.jsp";
    public static final String HOME_JSP = "/home.jsp";
    public static final String LOGIN_JSP = "/login.jsp";
    public static final String REGISTRATION_JSP = "/registration.jsp";
    public static final String CONFERENCE_JSP = "/conference.jsp";
    public static final String EDIT_HOME_JSP = "/edithome.jsp";
    public static final String EDIT_CONFERENCE_JSP = "/editconference.jsp";

    public static final String CONFERENCE_CONT = "/confCont";
    public static final String LOGOUT_CONT = "/logoutCont";
    public static final String REGISTRATION_CONT = "/registrationCont";
    public static final String CREATE_CONFERENCE_CONT = "/createConfCont";
    public static final String EDIT_CONFERENCE_CONT = "/editConfCont";

    /* PAGES CONSTANTS */
    public static final String LOGIN_LABEL = "login";
    public static final String PASSWORD_LABEL = "password";
    public static final String NAME_LABEL = "name";
    public static final String SURNAME_LABEL = "surname";
    public static final String AGE_LABEL = "age";
    public static final String EMAIL_LABEL = "email";
    public static final String PHONE_LABEL = "phone";

    public static final String CONF_TITLE_LABEL = "titleConf";
    public static final String DESCRIPTION_LABEL = "description";
    public static final String PLACE_LABEL = "place";
    public static final String DATE_LABEL = "date";

    public static final String EVENT_TITLE_LABEL = "titleEvent";
    public static final String TIME_LABEL = "time";

    public static final String SECTION_LABEL = "section";
    public static final String ACTION_LABEL = "action";

    public static final String ID_CONF_LABEL = "idConf";
    public static final String IDS_CONF_LABEL = "idsConf";

    /* MESSAGES */
    public static final String NOT_FOUND_USER_MESSAGE = "Incorrect login or password";
    public static final String EXIST_USER_MESSAGE = "User exist. Change login or email";

}
