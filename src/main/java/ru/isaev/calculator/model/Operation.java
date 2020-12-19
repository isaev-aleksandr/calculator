package ru.isaev.calculator.model;

import javax.persistence.*;

@Entity
@Table(name = "operations")
public class Operation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_number", nullable = false)
    private long firstNumber;

    @Column(name = "second_number", nullable = false)
    private long secondNumber;

    @Column(name = "operator", nullable = false)
    private String operator;

    @Column(name = "result", nullable = false)
    private long result;

    public Operation() {

    }
    public Operation(long firstNumber, long secondNumber, String operator, long result) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(long firstNumber) {
        this.firstNumber = firstNumber;
    }

    public long getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(long secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public long getResult() {
        return result;
    }

    public void setResult(long result) {
        this.result = result;
    }
}
