package wzw.test.product_server.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wzw.test.product_server.Entity.ProductEntity;
import wzw.test.product_server.Service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Value("${server.port}")
    private String port;
    @Autowired
    private ProductService productService;

    //获取所有列表
    @RequestMapping("list")
    public Object list() {
        return productService.listProduct();
    }

    //根据商品id查询商品详情
    @RequestMapping("find")
    public Object findById(@RequestParam("id") int id) {
        ProductEntity product = new ProductEntity();
        product = productService.findById(id);
        //ProductEntity result = new ProductEntity();
        //BeanUtils.copyProperties(product, result);
        //product.setName(result.getName() + " data from port=" + port);
        product.setRemark(" data from port=" + port);
        return product;
    }

}
