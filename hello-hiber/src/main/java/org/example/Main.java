package org.example;

import org.example.entity.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;

public class Main {
    public static void main(String[] args) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            //transaction = session.beginTransaction();

            Product product = new Product();
            product.setBrand_id(3L);
            product.setProduct_type_id(3L);
            product.setCategory_id(3L);
            product.setPrice(1.1);
            Long save = (Long) session.save(product);
            System.out.println(save);
           // System.out.println(save);
          //  transaction.commit();
           // session.close();
        }catch (Exception e) {
            e.printStackTrace();
          //  transaction.rollback();
        }
    }
}
