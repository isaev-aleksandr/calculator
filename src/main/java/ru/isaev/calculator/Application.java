package ru.isaev.calculator;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.isaev.calculator.config.AbstractJavaFxApplicationSupport;
import ru.isaev.calculator.config.ConfigurationControllers;


@SpringBootApplication
public class Application extends AbstractJavaFxApplicationSupport {

    @Autowired
    private ConfigurationControllers.View view;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Calculator");
        stage.setScene(new Scene(view.getView()));
        stage.setResizable(true);
        stage.centerOnScreen();
        stage.show();
        stage.getIcons().add(new Image("img.png"));
    }

    public static void main(String[] args) {
        launchApp(Application.class, args);
    }

}