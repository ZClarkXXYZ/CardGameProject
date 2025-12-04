module com.example.cardgameproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.cardgameproject to javafx.fxml;
    exports com.example.cardgameproject;
    exports com.example.cardgameproject.command;
    opens com.example.cardgameproject.command to javafx.fxml;
    exports com.example.cardgameproject.observerAndBuilder;
    opens com.example.cardgameproject.observerAndBuilder to javafx.fxml;
    exports com.example.cardgameproject.decorator;
    opens com.example.cardgameproject.decorator to javafx.fxml;
    exports com.example.cardgameproject.adapter;
    opens com.example.cardgameproject.adapter to javafx.fxml;
    exports com.example.cardgameproject.singleton;
    opens com.example.cardgameproject.singleton to javafx.fxml;
}