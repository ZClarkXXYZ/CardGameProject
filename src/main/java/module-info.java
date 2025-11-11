module com.example.cardgameproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cardgameproject to javafx.fxml;
    exports com.example.cardgameproject;
}