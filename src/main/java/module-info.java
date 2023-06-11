module com.example.javaacquaintance {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
                            
    opens com.example.javaacquaintance to javafx.fxml;
    exports com.example.javaacquaintance;
}