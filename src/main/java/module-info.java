module com.gabriel.myroute {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

	requires org.json;
	requires google.genai;
	requires java.desktop;
	requires okhttp3;
	requires jdk.httpserver;
   

    opens com.gabriel.myroute to javafx.fxml;
    opens com.gabriel.myroute.controller.Home to javafx.fxml;
    opens com.gabriel.myroute.controller.singUp to javafx.fxml;
    opens com.gabriel.myroute.controller.login to javafx.fxml;
    opens com.gabriel.myroute.controller.SarchOrPlan to javafx.fxml;
    opens com.gabriel.myroute.controller.Plan to javafx.fxml;
    opens com.gabriel.myroute.controller.Search to javafx.fxml;
    opens com.gabriel.myroute.controller.userController to javafx.fxml;
    
    exports com.gabriel.myroute;
}