package ru.isaev.calculator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.isaev.calculator.model.Operation;
import ru.isaev.calculator.persist.OperationRepository;
import ru.isaev.calculator.service.OperationService;

import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {

    private OperationRepository operationRepository;
    private String outputHistory = "";

    @Override
    @Autowired
    public void setOperationRepository(@Qualifier(value = "operationRepositoryImpl") OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @Override
    @Transactional
    public long calculation(long a, long b, String operator) {

        switch (operator) {
            case "+":
                operationRepository.saveOperationInDB(new Operation(a, b, operator, a + b));
                return a + b;
            case "-":
                operationRepository.saveOperationInDB(new Operation(a, b, operator, a - b));
                return a - b;
            case "*":
                operationRepository.saveOperationInDB(new Operation(a, b, operator, a * b));
                return a * b;
            case "/":
                if (b == 0) return 0;
                operationRepository.saveOperationInDB(new Operation(a, b, operator, a / b));
                return a / b;
        }
        System.out.println("Unknown operator");
        return 0;
    }

    @Override
    @Transactional
    public String getLust10Operations() {
        List<Operation> operationList = operationRepository.findLast10Operations();
        outputHistory = "";
        for (Operation operation : operationList) {
            outputHistory = outputHistory +
                    operation.getFirstNumber() +
                    operation.getOperator() +
                    operation.getSecondNumber() + "=" +
                    operation.getResult() +
                    "\n";
        }
        return outputHistory;
    }
}
