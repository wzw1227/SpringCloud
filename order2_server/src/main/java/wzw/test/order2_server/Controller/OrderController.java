package wzw.test.order2_server.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wzw.test.order2_server.Service.ProductOrderServerI;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    private ProductOrderServerI productOrderServerI;

    @RequestMapping("save")
    @HystrixCommand(fallbackMethod = "saveOrderFail")//访问失败时执行熔断
    public Object save(@RequestParam("user_id")int userId,@RequestParam("product_id")int productId ){

        Map<String,Object> data =new HashMap<>();
        data.put("code",1);
        data.put("data",productOrderServerI.save(userId,productId));
        return data;
    }

    //注意：方法名一定要和api方法一致
    private Object saveOrderFail(int userId,int productId){
        Map<String,Object> map =new HashMap<>();
        map.put("code","-1");
        map.put("msg","当前抢购人数太多，您被挤出了，稍等重试");
        return map;
    }
}
