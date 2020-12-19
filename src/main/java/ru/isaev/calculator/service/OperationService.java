package ru.isaev.calculator.service;

import ru.isaev.calculator.persist.OperationRepository;

public interface OperationService {

    void setOperationRepository(OperationRepository operationRepository);

    long calculation(long a, long b, String operator);

    String getLust10Operations();
}
