package com.forma.inventory.backend.services;

import com.forma.inventory.backend.entities.Product;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {

    // TODO: finish test class

    public static final String PERSISTENCE_UNIT_NAME = "finale";
    public static final ProductServiceImpl productService = new ProductServiceImpl(PERSISTENCE_UNIT_NAME);

    @BeforeEach
    public void deleteAll(){
        productService.truncate();
    }

    @AfterAll
    public static void clean(){
        productService.close();
    }

    private List<Product> createDummyProducts(){

        List<Product> productList = new ArrayList<>();

        Product product1 = new Product(
                "Prosoape",
                5,
                10
        );
        Product product2 = new Product(
                "Manusi",
                100,
                250
        );
        Product product3 = new Product(
                "Dezinfectant",
                20,
                50
        );

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        return productList;
    }

    @Test
    public void saveProduct(){

        Product product = createDummyProducts().get(0);

        productService.saveOrUpdate(product);

        assertNotNull(product);
        assertNotNull(product.getId());
        assertEquals("Prosoape", product.getName());
        assertEquals(5, product.getStockInSalon());
        assertEquals(10, product.getStockPerWeek());
        assertEquals(1, productService.getAll().size());
    }

    @Test
    public void saveProducts(){

        List<Product> productList = createDummyProducts();

        Product product1 = productList.get(0);
        Product product2 = productList.get(1);
        Product product3 = productList.get(2);

        productService.saveOrUpdateAllArray(product1, product2, product3);

        assertNotNull(product1);
        assertNotNull(product1.getId());
        assertEquals("Prosoape", product1.getName());
        assertEquals(5, product1.getStockInSalon());
        assertEquals(10, product1.getStockPerWeek());

        assertNotNull(product2);
        assertNotNull(product2.getId());
        assertEquals("Manusi", product2.getName());
        assertEquals(100, product2.getStockInSalon());
        assertEquals(250, product2.getStockPerWeek());

        assertNotNull(product3);
        assertNotNull(product3.getId());
        assertEquals("Dezinfectant", product3.getName());
        assertEquals(20, product3.getStockInSalon());
        assertEquals(50, product3.getStockPerWeek());

        assertEquals(3, productService.getAll().size());
    }

    @Test
    public void saveProductList(){

        List<Product> productList = createDummyProducts();

        productService.saveOrUpdateAllList(productList);

        productList.clear();
        productList = productService.getAll();
        Product product1 = productList.get(0);
        Product product2 = productList.get(1);
        Product product3 = productList.get(2);

        productList.forEach(Assertions::assertNotNull);

        assertNotNull(product1);
        assertNotNull(product1.getId());
        assertEquals("Prosoape", product1.getName());
        assertEquals(5, product1.getStockInSalon());
        assertEquals(10, product1.getStockPerWeek());

        assertNotNull(product2);
        assertNotNull(product2.getId());
        assertEquals("Manusi", product2.getName());
        assertEquals(100, product2.getStockInSalon());
        assertEquals(250, product2.getStockPerWeek());

        assertNotNull(product3);
        assertNotNull(product3.getId());
        assertEquals("Dezinfectant", product3.getName());
        assertEquals(20, product3.getStockInSalon());
        assertEquals(50, product3.getStockPerWeek());

        assertEquals(3, productService.getAll().size());
    }

    @Test
    public void updateProduct(){

        Product product = createDummyProducts().get(0);

        Product productBeforeUpdate = productService.saveOrUpdate(product);

        assertNotNull(productBeforeUpdate);
        assertNotNull(productBeforeUpdate.getId());
        assertEquals("Prosoape", productBeforeUpdate.getName());
        assertEquals(5, productBeforeUpdate.getStockInSalon());
        assertEquals(10, productBeforeUpdate.getStockPerWeek());

        product.setName("ProsoapeUpdate");

        Product productAfterUpdate = productService.update(product);

        assertNotNull(productAfterUpdate);
        assertNotNull(productAfterUpdate.getId());
        assertEquals("ProsoapeUpdate", productAfterUpdate.getName());
        assertEquals(5, productAfterUpdate.getStockInSalon());
        assertEquals(10, productAfterUpdate.getStockPerWeek());

        assertEquals(productBeforeUpdate.getId(), productAfterUpdate.getId());
        assertNotEquals(productBeforeUpdate, productAfterUpdate);
    }

    @Test
    public void updateProducts(){
        List<Product> productList = createDummyProducts();

        Product product1 = productList.get(0);
        Product product2 = productList.get(1);
        Product product3 = productList.get(2);

        productService.saveOrUpdateAllArray(product1, product2, product3);

        assertEquals(3, productService.getAll().size());
    }

    @Test
    public void updateProductList(){

    }
}
