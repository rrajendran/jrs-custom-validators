package com.capella.jsr.validators.date;

/**
 *
 * <p>
 * Created on : 12/30/15
 *
 * @author Ramesh Rajendran
 */
@DateRange(fields = {"startDate","endDate"},format = "dd-MM-yyyy", message = "Given dates are not in valid range")
public class DateRangeObject {

    private String startDate;
    private String endDate;

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }


    public static class DateRangeObjectBuilder {
        private String endDate;
        private String startDate;

        private DateRangeObjectBuilder() {
        }

        public static DateRangeObjectBuilder getInstance() {
            return new DateRangeObjectBuilder();
        }

        public DateRangeObjectBuilder endDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        public DateRangeObjectBuilder startDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public DateRangeObject build() {
            DateRangeObject dateRangeObject = new DateRangeObject();
            dateRangeObject.setEndDate(endDate);
            dateRangeObject.setStartDate(startDate);
            return dateRangeObject;
        }
    }
}
