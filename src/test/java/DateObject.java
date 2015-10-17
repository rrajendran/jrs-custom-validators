import uk.gov.ipt.validators.date.ValidDate;

import java.time.LocalDate;

public class DateObject {

    private LocalDate startDate;

    private LocalDate endDate;

    @ValidDate(format = "dd-MM-yyyy")
    private String date;

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getDate() {
        return date;
    }

    public DateObject setDate(String date) {
        this.date = date;
        return this;
    }

    public static class DateObjectBuilder {
        private LocalDate endDate;
        private LocalDate startDate;
        private String date;

        private DateObjectBuilder() {
        }

        public static DateObjectBuilder aDateObject() {
            return new DateObjectBuilder();
        }

        public DateObjectBuilder endDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public DateObjectBuilder startDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public DateObjectBuilder date(String date) {
            this.date = date;
            return this;
        }

        public DateObjectBuilder but() {
            return aDateObject().endDate(endDate).startDate(startDate).date(date);
        }

        public DateObject build() {
            DateObject dateObject = new DateObject();
            dateObject.setEndDate(endDate);
            dateObject.setStartDate(startDate);
            dateObject.setDate(date);
            return dateObject;
        }
    }
}