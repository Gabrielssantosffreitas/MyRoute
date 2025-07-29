module com.gabriel.myroute {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.gabriel.myroute to javafx.fxml;
    exports com.gabriel.myroute;
}