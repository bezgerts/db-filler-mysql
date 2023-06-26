package me.bezgerts.dbfillermysql.repositories;

import jakarta.transaction.Transactional;
import me.bezgerts.dbfillermysql.entities.mysql.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, UUID> {
}
