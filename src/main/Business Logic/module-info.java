module com.example.javaaidietician {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javaaidietician to javafx.fxml;
    exports com.example.javaaidietician;
}