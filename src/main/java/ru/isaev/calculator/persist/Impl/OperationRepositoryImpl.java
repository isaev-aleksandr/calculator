package ru.isaev.calculator.persist.Impl;

import org.springframework.stereotype.Repository;
import ru.isaev.calculator.model.Operation;
import ru.isaev.calculator.persist.OperationRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class OperationRepositoryImpl implements OperationRepository {

    private EntityManager entityManager;

    @PersistenceContext
    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Operation> findLast10Operations (){
        Query query = entityManager.createQuery("FROM Operation order by id DESC");
        query.setMaxResults(10);
        return  query.getResultList();
    }

    @Override
    public void saveOperationInDB (Operation operation){
        entityManager.persist(operation);
    }


}
