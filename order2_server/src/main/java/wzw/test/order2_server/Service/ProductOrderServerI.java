package wzw.test.order2_server.Service;

import wzw.test.order2_server.Entity.ProductOrderEntity;


public interface ProductOrderServerI {
    /*
    订单服务客户端
     */
    ProductOrderEntity save(int userId, int ProductId);

}
