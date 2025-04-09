module org.example.movieinfo {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens org.example.movieinfo to javafx.fxml;
    exports org.example.movieinfo;
}