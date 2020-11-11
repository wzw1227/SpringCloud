package wzw.test.order2_server.Service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wzw.test.order2_server.Entity.ProductOrderEntity;

import wzw.test.order2_server.Service.ProducrClient;
import wzw.test.order2_server.Service.ProductOrderServerI;
import wzw.test.order2_server.Utils.JsonUtils;

import java.util.Date;
import java.util.UUID;

@Service
public class ProductOrderServiceImpl implements ProductOrderServerI {

    @Autowired
    ProducrClient producrClient;

    @Override
    public ProductOrderEntity save(int userId, int ProductId) {
        //调用商品服务
        String response = producrClient.findByid(ProductId);//返回字符串
        JsonNode jsonNode =JsonUtils.str2JsonNode(response);//将字符串转换成json格式数据

        //调用用户服务，获取用户信息
        ProductOrderEntity entity = new ProductOrderEntity();
        entity.setCreateTime(new Date());
        entity.setUserId(userId);
        entity.setTradeNo(UUID.randomUUID().toString());
        entity.setProductname(jsonNode.get("name").toString());
        entity.setPrice(Integer.parseInt(jsonNode.get("price").toString()));

        return entity;
    }
}
