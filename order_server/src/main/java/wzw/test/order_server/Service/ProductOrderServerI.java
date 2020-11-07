package wzw.test.order_server.Service;

import wzw.test.order_server.Entity.ProductOrderEntity;

public interface ProductOrderServerI {
    /*
    用户下单接口
     */
    ProductOrderEntity save(int userId,int ProductId);
}
