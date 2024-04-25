package com.example.passwordgenerator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label PassLabel;
    @FXML
    private TextField textField;

    public void generate(ActionEvent actionEvent) {
        try {
            int length = textField.getText().isEmpty() ? 12 : Integer.parseInt(textField.getText());
            PassLabel.setText(passwordGenerator(length));
        } catch (NumberFormatException e) {
            PassLabel.setText("Please enter a valid number");
        }
    }
    protected String passwordGenerator(int length) {
        StringBuilder password = new StringBuilder();
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialCharacters = "!@#$%^&*_=+-/.?<>)";

        String values = upperCase + lowerCase + numbers + specialCharacters;

        for (int i = 0; i < length; i++) {
            int index = (int) (values.length() * Math.random());
            password.append(values.charAt(index));
        }
        return password.toString();
    }
}