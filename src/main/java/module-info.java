module com.virtunexa.week2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.virtunexa.week2 to javafx.fxml;
    exports com.virtunexa.week2;
}