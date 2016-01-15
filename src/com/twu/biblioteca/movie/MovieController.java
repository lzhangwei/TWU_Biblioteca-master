package com.twu.biblioteca.movie;

import com.twu.biblioteca.account.AccountController;

import java.util.ArrayList;
import java.util.List;

public class MovieController {
    {
        createMovies();
    }

    private List<Movie> libraryMovieList;
    private List<Movie> currentMovieList;
    private AccountController accountController;

    private void createMovies() {
        libraryMovieList = new ArrayList<>();
        currentMovieList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            libraryMovieList.add(new Movie("MOVIE" + i, "DIRECTOR" + i, "2015", "2"));
            currentMovieList.add(new Movie("MOVIE" + i, "DIRECTOR" + i, "2015", "2"));
        }
    }

    public MovieController(AccountController accountController) {
        this.accountController = accountController;
    }

    public List<Movie> getLibraryMovieList() {
        return libraryMovieList;
    }

    public List<Movie> getCurrentMovieList() {
        return currentMovieList;
    }

    public void printMovieInfo(Movie movie) {
        System.out.println(String.format("     %s   %s   %s   %s", movie.getName(), movie.getDirector(), movie.getYear(), movie.getRating()));
    }

    public void checkoutMovie(String checkoutMovieName) {
        for (int i = 0; i < currentMovieList.size(); i++) {
            if (checkoutMovieName.equals(currentMovieList.get(i).getName())) {
                accountController.addCheckoutMovie(currentMovieList.get(i));
                currentMovieList.remove(i);
                return;
            }
        }
    }
}
