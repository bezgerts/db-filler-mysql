package me.bezgerts.dbfillermysql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.bezgerts.dbfillermysql.entities.mysql.Product;
import me.bezgerts.dbfillermysql.entities.mysql.Supplier;
import me.bezgerts.dbfillermysql.repositories.ProductRepository;
import me.bezgerts.dbfillermysql.repositories.SupplierRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class DbFillerMysqlApplication implements CommandLineRunner {

    private static final char[] pool = {
            'a','b','c','d','e','f','g',
            'h','i','j','k','l','m','n',
            'o','p','q','r','s','t','u',
            'v','w','x','y','z'
    };

    private final SupplierRepository supplierRepository;
    private final ProductRepository productRepository;



    public static void main(String[] args) {
        SpringApplication.run(DbFillerMysqlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Supplier> suppliers = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Supplier supplier = new Supplier();
            supplier.setName(getStr(50));
            supplier.setAddress(getStr(150));
            suppliers.add(supplier);
        }
        supplierRepository.saveAllAndFlush(suppliers);

        for (int i = 0; i < 10000; i++) {
            Product product = new Product();
            product.setName(getStr(50));
            product.setDescription(getStr(1024));
            product.setLink(getStr(50));
            product.setSupplier(suppliers.get(ThreadLocalRandom.current().nextInt(0, 1000)));
            product.setCost(ThreadLocalRandom.current().nextInt(0, 30000));
            products.add(product);
        }
        productRepository.saveAllAndFlush(products);
    }

    public char getChar(Random rnd) { return pool[rnd.nextInt(pool.length)]; }

    public String getStr(int size) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++)
            sb.append(getChar(random));
        return new String(sb);
    }
}
