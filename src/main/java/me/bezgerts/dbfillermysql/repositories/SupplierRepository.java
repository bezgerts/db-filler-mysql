package me.bezgerts.dbfillermysql.repositories;

import jakarta.transaction.Transactional;
import me.bezgerts.dbfillermysql.entities.mysql.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Transactional
public interface SupplierRepository extends JpaRepository<Supplier, UUID> {
}
