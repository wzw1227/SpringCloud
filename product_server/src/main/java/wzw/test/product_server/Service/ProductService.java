package wzw.test.product_server.Service;

import wzw.test.product_server.Entity.ProductEntity;

import java.util.List;

public interface ProductService {
    List<ProductEntity> listProduct();

    ProductEntity findById(int id);
}
