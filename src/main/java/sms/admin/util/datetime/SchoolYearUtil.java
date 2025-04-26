package sms.admin.util.datetime;

import dev.finalproject.models.SchoolYear;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.time.LocalDate;

public class SchoolYearUtil {

    /**
     * Formats a SchoolYear as "YYYY-YYYY" (e.g., "2023-2024")
     */
    public static String formatSchoolYear(SchoolYear schoolYear) {
        return String.format("%d-%d",
                schoolYear.getYearStart(),
                schoolYear.getYearEnd());
    }

    /**
     * Converts SchoolYear objects into formatted strings for display
     */
    public static ObservableList<String> convertToStringList(ObservableList<SchoolYear> schoolYears) {
        return schoolYears.stream()
                .map(SchoolYearUtil::formatSchoolYear)
                .collect(FXCollections::observableArrayList,
                        ObservableList::add,
                        ObservableList::addAll);
    }

    /**
     * Determines if the given SchoolYear is the current academic year
     */
    public static boolean isCurrentYear(SchoolYear sy) {
        LocalDate now = LocalDate.now();
        int currentYear = now.getYear();
        int currentMonth = now.getMonthValue();

        // Academic year runs July-June; before June means we're still in previous year's cycle
        if (currentMonth < 6) {
            return sy.getYearStart() == (currentYear - 1);
        } else {
            return sy.getYearStart() == currentYear;
        }
    }

    /**
     * Finds the SchoolYear that matches the current academic year
     */
    public static SchoolYear findCurrentYear(ObservableList<SchoolYear> schoolYears) {
        return schoolYears.stream()
                .filter(SchoolYearUtil::isCurrentYear)
                .findFirst()
                .orElse(null);
    }
}
