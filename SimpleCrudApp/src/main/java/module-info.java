module com.example.simplecrudapp {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.buttonow.simplecrudapp to javafx.fxml;
    exports com.buttonow.simplecrudapp;
}