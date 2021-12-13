module Lowe {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.base;
    opens lowe.groupproject to javafx.fxml;
    exports lowe.groupproject;
}