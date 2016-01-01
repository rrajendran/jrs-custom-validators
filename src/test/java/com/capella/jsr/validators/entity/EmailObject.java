package com.capella.jsr.validators.entity;

import com.capella.jsr.validators.date.ValidEmail;

/**
 * Created by ramesh on 01/01/2016.
 */
public class EmailObject {
    @ValidEmail(message = "This email is not valid")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EmailObject{" +
                "email='" + email + '\'' +
                '}';
    }

    public static class EmailObjectBuilder {
        private String email;

        private EmailObjectBuilder() {
        }

        public static EmailObjectBuilder getInstance() {
            return new EmailObjectBuilder();
        }

        public EmailObjectBuilder email(String email) {
            this.email = email;
            return this;
        }

        public EmailObject build() {
            EmailObject emailObject = new EmailObject();
            emailObject.setEmail(email);
            return emailObject;
        }
    }
}
