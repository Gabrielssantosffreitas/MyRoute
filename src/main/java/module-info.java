module com.gabriel.myroute {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

	requires org.json;
	requires google.genai;
   

    opens com.gabriel.myroute to javafx.fxml;
    opens com.gabriel.myroute.controller.Home to javafx.fxml;
    opens com.gabriel.myroute.controller.singUp to javafx.fxml;
    opens com.gabriel.myroute.controller.login to javafx.fxml;
    exports com.gabriel.myroute;
}