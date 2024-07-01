module com.example.javabackpacktask {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javabackpacktask to javafx.fxml;
    exports com.example.javabackpacktask;
}