module com.example.javaacquaintance {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.javaacquaintance to javafx.fxml;
    exports com.example.javaacquaintance;
}