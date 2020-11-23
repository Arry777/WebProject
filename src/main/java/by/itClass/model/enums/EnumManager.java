package by.itClass.model.enums;

public class EnumManager {
    public static SectionMenu getKindSectionMenu(String section) {
        try {
            return SectionMenu.valueOf(section.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            return SectionMenu.TODAY;
        }
    }

    public static ActionConference getKindActionConference(String action) {
        try {
            return ActionConference.valueOf(action.toUpperCase());
        } catch (IllegalArgumentException e) {
            return ActionConference.NONE;
        }
    }
}
