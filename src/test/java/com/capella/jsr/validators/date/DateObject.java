package com.capella.jsr.validators.date;

public class DateObject {

    @ValidDate(format = "dd-MM-yyyy")
    private String date;


    public String getDate() {
        return date;
    }

    public DateObject setDate(String date) {
        this.date = date;
        return this;
    }

    public static class DateObjectBuilder {
        private String date;

        private DateObjectBuilder() {
        }

        public static DateObjectBuilder aDateObject() {
            return new DateObjectBuilder();
        }

        public DateObjectBuilder date(String date) {
            this.date = date;
            return this;
        }

        public DateObjectBuilder but() {
            return aDateObject().date(date);
        }

        public DateObject build() {
            DateObject dateObject = new DateObject();
            dateObject.setDate(date);
            return dateObject;
        }
    }
}