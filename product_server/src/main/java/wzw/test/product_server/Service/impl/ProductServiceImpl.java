package wzw.test.product_server.Service.impl;

import org.springframework.stereotype.Service;
import wzw.test.product_server.Entity.ProductEntity;
import wzw.test.product_server.Service.ProductService;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Map<Integer, ProductEntity> daoMap = new HashMap<>();
    private static final List<ProductEntity> daoList = new ArrayList<>();

    //模拟数据map
    static {
        ProductEntity p1 = new ProductEntity(1, "iphonex", 6520, 10);
        ProductEntity p2 = new ProductEntity(2, "huaweip40", 5410, 20);
        ProductEntity p3 = new ProductEntity(3, "冰箱", 6500, 8);
        ProductEntity p4 = new ProductEntity(4, "电视", 4500, 15);
        ProductEntity p5 = new ProductEntity(4, "洗衣机", 5500, 5);
        daoMap.put(p1.getId(), p1);
        daoMap.put(p2.getId(), p2);
        daoMap.put(p3.getId(), p3);
        daoMap.put(p4.getId(), p4);
        daoMap.put(p5.getId(), p5);
    }

    //模拟数据list
    static {
        ProductEntity p1 = new ProductEntity(1, "iphonex", 6520, 10);
        ProductEntity p2 = new ProductEntity(2, "huaweip40", 5410, 20);
        ProductEntity p3 = new ProductEntity(3, "冰箱", 6500, 8);
        ProductEntity p4 = new ProductEntity(4, "电视", 4500, 15);
        ProductEntity p5 = new ProductEntity(4, "洗衣机", 5500, 5);
        daoList.add(p1);
        daoList.add(p2);
        daoList.add(p3);
        daoList.add(p4);
        daoList.add(p5);
    }

    @Override
    public List<ProductEntity> listProduct() {
        //map转list
        Collection<ProductEntity> collation = daoMap.values();
        List<ProductEntity> list = new ArrayList<>(collation);
        return list;
    }

    @Override
    public ProductEntity findById(int id) {
        return daoMap.get(id);
    }
}
