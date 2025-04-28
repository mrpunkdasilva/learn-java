package com.framework.aspects;

import com.framework.exceptions.DIException;
import java.lang.reflect.Method;

public class TransactionInterceptor {
    public Object intercept(Object target, Method method, Object[] args) {
        if (!method.isAnnotationPresent(Transactional.class)) {
            try {
                return method.invoke(target, args);
            } catch (Exception e) {
                throw new DIException("Error invoking method", e);
            }
        }

        beginTransaction();
        try {
            Object result = method.invoke(target, args);
            commitTransaction();
            return result;
        } catch (Exception e) {
            rollbackTransaction();
            throw new DIException("Transaction failed", e);
        }
    }

    private void beginTransaction() {
        // Implementação do início da transação
        System.out.println("Beginning transaction");
    }

    private void commitTransaction() {
        // Implementação do commit
        System.out.println("Committing transaction");
    }

    private void rollbackTransaction() {
        // Implementação do rollback
        System.out.println("Rolling back transaction");
    }
}