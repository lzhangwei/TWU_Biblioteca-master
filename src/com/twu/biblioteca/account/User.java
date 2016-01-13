package com.twu.biblioteca.account;

public class User {
    private String libraryNumber;
    private String name;
    private String email;
    private String phone;

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public void setLibraryNumber(String libraryNumber) {
        this.libraryNumber = libraryNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static class UserBuilder {
        private String libraryNumber;
        private String name;
        private String email;
        private String phone;

        private UserBuilder() {
        }

        public static UserBuilder anUser() {
            return new UserBuilder();
        }

        public UserBuilder withLibraryNumber(String libraryNumber) {
            this.libraryNumber = libraryNumber;
            return this;
        }

        public UserBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder but() {
            return anUser().withLibraryNumber(libraryNumber).withName(name).withEmail(email).withPhone(phone);
        }

        public User build() {
            User user = new User();
            user.setLibraryNumber(libraryNumber);
            user.setName(name);
            user.setEmail(email);
            user.setPhone(phone);
            return user;
        }
    }
}
