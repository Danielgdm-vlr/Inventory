package com.forma.inventory.backend.repositories;

import com.forma.inventory.backend.entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ProductRepository extends GenericRepository<Product> {

    private final EntityManagerFactory entityManagerFactory;

    public ProductRepository(EntityManagerFactory entityManagerFactory){

        super(Product.class);
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public EntityManager getEntityManager(){

        try{
            return entityManagerFactory.createEntityManager();
        }catch (Exception exception){
            System.out.println("The entity cannot be created!");
            exception.printStackTrace();
            return null;
        }
    }
}
