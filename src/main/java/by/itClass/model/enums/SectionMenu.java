package by.itClass.model.enums;

import by.itClass.constants.SQLRequests;

public enum SectionMenu {
    HOME(SQLRequests.WHERE_HOME),
    TODAY(SQLRequests.WHERE_TODAY),
    TOMORROW(SQLRequests.WHERE_TOMORROW),
    SOON(SQLRequests.WHERE_SOON),
    PASSED(SQLRequests.WHERE_PASSED),
    ALL(SQLRequests.WHERE_ALL);

    private String sql;

    private SectionMenu(String subsql) {
        sql = SQLRequests.SELECT_CONFERENCES + subsql;
    }

    public String getSql() {
        return sql;
    }
}
