package wzw.test.order_server.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import wzw.test.order_server.Entity.ProductOrderEntity;
import wzw.test.order_server.Service.ProductOrderServerI;

import java.util.Date;
import java.util.UUID;

@Service
public class ProductOrderServiceImpl implements ProductOrderServerI {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ProductOrderEntity save(int userId, int ProductId) {
        //获取商品服务
       Object obj = restTemplate.getForEntity("http://product-service/api/v1/product/find?id="+ProductId,Object.class);
        System.out.println(obj);

        ProductOrderEntity entity = new ProductOrderEntity();
        entity.setCreateTime(new Date());
        entity.setUserId(userId);
        entity.setTradeNo(UUID.randomUUID().toString());

        return entity;
    }
}
