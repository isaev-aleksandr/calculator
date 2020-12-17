package ru.isaev.calculator.model;

import javax.persistence.*;

@Entity
@Table(name = "operations")
public class Operations {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_number", nullable = false)
    private String firstNumber;

    @Column(name = "second_number", nullable = false)
    private String secondNumber;

    @Column(name = "operator", nullable = false)
    private String operator;

    @Column(name = "result", nullable = false)
    private String result;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(String firstNumber) {
        this.firstNumber = firstNumber;
    }

    public String getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(String secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
