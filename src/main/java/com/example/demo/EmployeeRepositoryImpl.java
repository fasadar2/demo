package com.example.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {
        @Autowired
        EntityManager em;
    @Override
    @Transactional
    public List<Employee> findEmployeesByName(String name){
        CriteriaBuilder cb1 = em.getCriteriaBuilder();
        CriteriaUpdate<Employee> cu1 = cb1.createCriteriaUpdate(Employee.class);
        Root<Employee> employeeRoot = cu1.from(Employee.class);
        cu1.set(employeeRoot.get("name"),"Максим").where(cb1.like(employeeRoot.get("name"), "Алексей"));
        em.createQuery(cu1).executeUpdate();

        CriteriaBuilder cb = em.getCriteriaBuilder();
       CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);


        Root<Employee> employee = cq.from(Employee.class);
        Predicate namePredicate = cb.like(employee.get("name"),name);
        cq.where(namePredicate);
        TypedQuery<Employee> query = em.createQuery(cq);
        return query.getResultList();

    }
}
