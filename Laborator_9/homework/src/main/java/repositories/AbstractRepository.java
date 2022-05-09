package repositories;

import entityManager.Manager;

import javax.persistence.EntityManager;

public abstract class AbstractRepository <T>{
    protected EntityManager manager;

    public AbstractRepository() {
        Manager managerInstance = Manager.getInstance();
        manager = managerInstance.getManager();
    }

    /**
     * Inserts a new row to the table specified for every entity
     * @param entity The entity that will be inserted
     */
    public void create(T entity) {
        manager.persist(entity);
        manager.getTransaction().commit();
        manager.getTransaction().begin();
    }
}
