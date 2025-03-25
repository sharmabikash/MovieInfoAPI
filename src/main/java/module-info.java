module org.example.movieinfo {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.movieinfo to javafx.fxml;
    exports org.example.movieinfo;
}