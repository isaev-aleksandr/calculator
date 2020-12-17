package ru.isaev.calculator.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.isaev.calculator.Service;

@Component
public class Controller {

    @FXML
    private Text output;
    private long number1 = 0;
    private long number2 = 0;

    private boolean start = true;

    private String operator = "";
    private Service service;

    @Autowired
    public void setModel(Service service) {
        this.service = service;
    }

    @FXML
    public void initialize() {
    }

    @FXML
    public void processNumber(ActionEvent event) {
        if (start) {
            output.setText("");
            start = false;
        }
        String value = ((Button) event.getSource()).getText();
        output.setText(output.getText() + value);
    }

    @FXML
    public void processOperator(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (!"=".equals(value)) {
            if (!operator.isEmpty()) return;
            operator = value;
            number1 = Long.parseLong(output.getText());
            output.setText("");
        } else {
            if (operator.isEmpty()) return;
            output.setText(String.valueOf(service.calculation(number1, Long.parseLong(output.getText()), operator)));
            operator = "";
            start = true;
        }
    }
}
