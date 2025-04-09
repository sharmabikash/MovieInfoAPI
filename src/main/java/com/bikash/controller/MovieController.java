package com.bikash;

import com.bikash.model.Movie;
import com.bikash.service.MovieService;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class MovieController {

    @FXML
    private TextField searchField;

    @FXML
    private Button searchButton;

    @FXML
    private ListView<Movie> movieListView;

    @FXML
    private Label statusLabel;

    private final MovieService movieService = new MovieService();

    @FXML
    private void initialize() {
        searchButton.setOnAction(e -> searchMovies());
    }

    private void searchMovies() {
        String title = searchField.getText().trim();
        if (title.isEmpty()) {
            statusLabel.setText("Please enter a movie title.");
            return;
        }

        List<Movie> movies = movieService.searchMovies(title);
        movieListView.getItems().setAll(movies);
        statusLabel.setText(movies.size() + " result(s) found.");
    }
}
