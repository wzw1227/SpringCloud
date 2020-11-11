package wzw.test.order2_server.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wzw.test.order2_server.Exception.ProductClientFallback;

/*
name:将要调用的服务名
fallback:指定降级调用自定义异常类
 */
@FeignClient(name = "product-service",fallback = ProductClientFallback.class)
public interface ProducrClient {

    @GetMapping("/api/v1/product/find")//调用服务的指定方法
    String findByid(@RequestParam(value = "id")int id);


}
