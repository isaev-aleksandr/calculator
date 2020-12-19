package ru.isaev.calculator.persist;

import ru.isaev.calculator.model.Operation;

import javax.persistence.EntityManager;
import java.util.List;

public interface OperationRepository {

    void setEntityManager(EntityManager entityManager);

    List<Operation> findLast10Operations ();

    void saveOperationInDB (Operation operation);

}
