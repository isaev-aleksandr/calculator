package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {


    @FXML
    private Text output;
    private long number1 = 0;
    private long number2 = 0;

    private boolean start = true;

    private String operator = "";
    private Model model = new Model();


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
            output.setText(String.valueOf(model.calculation(number1, Long.parseLong(output.getText()), operator)));
            operator = "";
            start = true;
        }
    }
}
