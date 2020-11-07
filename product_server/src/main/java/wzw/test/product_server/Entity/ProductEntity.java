package wzw.test.product_server.Entity;

import java.io.Serializable;

public class ProductEntity implements Serializable {
    private int id;//id
    private String name;//名称
    private int price;//价格
    private int store;//库存
    private String remark;//备注

    public ProductEntity() {
    }

    public ProductEntity(int id, String name, int price, int store) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.store = store;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
