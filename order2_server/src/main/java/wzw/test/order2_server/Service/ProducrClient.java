package wzw.test.order2_server.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-service")//将要调用的服务名
public interface ProducrClient {

    @GetMapping("/api/v1/product/find")//调用服务的指定方法
    String findByid(@RequestParam(value = "id")int id);
}
