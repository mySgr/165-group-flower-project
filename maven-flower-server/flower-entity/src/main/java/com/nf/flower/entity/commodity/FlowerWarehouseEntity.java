package com.nf.flower.entity.commodity;

/**
 * 仓库表
 * CREATE TABLE flower_warehouse
 * (
 * id INT AUTO_INCREMENT COMMENT'仓库编号',
 * ware_name VARCHAR(100) COMMENT '仓库名称',
 * <p>
 * capacity INT COMMENT '仓库总容量',
 * stock INT COMMENT '当前仓库存量',
 * `status` INT COMMENT '仓库状态 ，1 正常 2，仓库已满',
 * ware_explain VARCHAR(1000) COMMENT '存放说明',
 * PRIMARY KEY(id)
 * )
 */
public class FlowerWarehouseEntity {
    private Integer id;
    private String wareName;
    private Integer capacity;
    private Integer stock;
    private Integer status;
    private String wareExplain;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWareName() {
        return wareName;
    }

    public void setWareName(String wareName) {
        this.wareName = wareName;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getWareExplain() {
        return wareExplain;
    }

    public void setWareExplain(String wareExplain) {
        this.wareExplain = wareExplain;
    }

    @Override
    public String toString() {
        return "FlowerWarehouseEntity{" +
                "id=" + id +
                ", wareName='" + wareName + '\'' +
                ", capacity=" + capacity +
                ", stock=" + stock +
                ", status=" + status +
                ", wareExplain='" + wareExplain + '\'' +
                '}';
    }
}
