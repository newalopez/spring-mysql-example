package com.is4tech.javaday;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 3/11/17.
 */
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
