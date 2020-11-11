package wzw.test.order2_server.Exception;

import org.springframework.stereotype.Component;
import wzw.test.order2_server.Service.ProducrClient;

/*
降级异常异常处理自定义类
针对商品服务做降级处理
 */
@Component
public class ProductClientFallback implements ProducrClient {
    @Override
    public String findByid(int id) {
        System.out.println("feign 调用product_server finbyid异常");
        return null;
    }
}
