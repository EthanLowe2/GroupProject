module Lowe {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens lowe.groupproject to javafx.fxml;
    exports lowe.groupproject;
}