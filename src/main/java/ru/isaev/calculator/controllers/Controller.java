package ru.isaev.calculator.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.isaev.calculator.service.OperationService;

@Component
public class Controller {

    private boolean start = true;
    private long number = 0;
    private String operator = "";

    @FXML
    private Text output;

    @FXML
    private TextArea outputHistory;

    private OperationService service;

    @Autowired
    public void setOperationService(@Qualifier(value = "operationServiceImpl") OperationService service) {
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
            if (!operator.isEmpty() || output.getText().equals("")) return;
            operator = value;
            number = Long.parseLong(output.getText());
            output.setText("");
        } else {
            if (operator.isEmpty() || output.getText().equals("")) return;
            output.setText(String.valueOf(service.calculation(number, Long.parseLong(output.getText()), operator)));
            outputHistory.setText(service.getLust10Operations());
            operator = "";
            start = true;
        }
    }

    @FXML
    public void processClear(ActionEvent event) {
        output.setText("");
        number = 0;
        start = true;
        operator = "";
    }
}
