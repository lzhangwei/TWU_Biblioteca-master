package com.twu.biblioteca.movie;

public class Movie {
    private String name;
    private String year;
    private String director;
    private String rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public static class MovieBuilder {
        private String name;
        private String year;
        private String director;
        private String rating;

        private MovieBuilder() {
        }

        public static MovieBuilder aMovie() {
            return new MovieBuilder();
        }

        public MovieBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public MovieBuilder withYear(String year) {
            this.year = year;
            return this;
        }

        public MovieBuilder withDirector(String director) {
            this.director = director;
            return this;
        }

        public MovieBuilder withRating(String rating) {
            this.rating = rating;
            return this;
        }

        public MovieBuilder but() {
            return aMovie().withName(name).withYear(year).withDirector(director).withRating(rating);
        }

        public Movie build() {
            Movie movie = new Movie();
            movie.setName(name);
            movie.setYear(year);
            movie.setDirector(director);
            movie.setRating(rating);
            return movie;
        }
    }
}
