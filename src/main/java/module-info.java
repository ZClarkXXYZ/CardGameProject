module com.example.cardgameproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.cardgameproject to javafx.fxml;
    exports com.example.cardgameproject;
}