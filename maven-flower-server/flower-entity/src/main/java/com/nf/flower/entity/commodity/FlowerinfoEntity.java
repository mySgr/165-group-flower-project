package com.nf.flower.entity.commodity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.nf.flower.tools.Common;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 鲜花表
 * CREATE TABLE flower(
 * flower_id INT AUTO_INCREMENT COMMENT'鲜花编号',
 * title VARCHAR(32)COMMENT'鲜花标题',
 * <p>
 * cover VARCHAR(128)COMMENT'封面图',
 * material VARCHAR(60)COMMENT'材料',
 * pack VARCHAR(60)COMMENT'包装',
 * <p>
 * price DECIMAL(10,2)COMMENT'销售价格',
 * stock INT COMMENT'库存',
 * buy_Count INT COMMENT'已售数量',
 * <p>
 * flower_language VARCHAR(40)COMMENT'花语',
 * details VARCHAR(60)COMMENT'产品说明',
 * <p>
 * status INT COMMENT'鲜花状态，1 表示上架，2 表示下架',
 * created DATETIME NOT NULL DEFAULT NOW()COMMENT'创建时间',
 * <p>
 * purpose_id INT COMMENT'鲜花用途编号',
 * warehouse_id INT COMMENT'仓库编号',
 * PRIMARY KEY(flower_id)
 * )
 */
public class FlowerinfoEntity {

    private Integer flowerId; // 鲜花编号

    private String title;

    private String cover;
    private String coverSrc;

    private String material;

    private String pack;

    private BigDecimal price;

    private Integer stock;

    private Integer buyCount;

    private String flowerLanguage;

    private String details;

    private Integer status;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime created;


    private Integer purposeId;   // 鲜花用途 编号

    private Integer warehouseId;    // 仓库编号

    private FlowerPurposeEntity flowerPurposeEntity;

    public FlowerinfoEntity() {
    }


    public Integer getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(Integer flowerId) {
        this.flowerId = flowerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCoverSrc() {
        return Common.IP_ADDRESS + cover;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public String getFlowerLanguage() {
        return flowerLanguage;
    }

    public void setFlowerLanguage(String flowerLanguage) {
        this.flowerLanguage = flowerLanguage;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Integer getPurposeId() {
        return purposeId;
    }

    public void setPurposeId(Integer purposeId) {
        this.purposeId = purposeId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public FlowerPurposeEntity getFlowerPurposeEntity() {
        return flowerPurposeEntity;
    }

    public void setFlowerPurposeEntity(FlowerPurposeEntity flowerPurposeEntity) {
        this.flowerPurposeEntity = flowerPurposeEntity;
    }

    @Override
    public String toString() {
        return "FlowerEntity{" +
                "flowerId=" + flowerId +
                ", title='" + title + '\'' +
                ", cover='" + cover + '\'' +
                ", material='" + material + '\'' +
                ", pack='" + pack + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", buyCount=" + buyCount +
                ", flowerLanguage='" + flowerLanguage + '\'' +
                ", details='" + details + '\'' +
                ", status=" + status +
                ", created=" + created +
                ", purposeId=" + purposeId +
                ", warehouseId=" + warehouseId +
                ", flowerPurposeEntity=" + flowerPurposeEntity +
                '}';
    }

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        FlowerinfoEntity entity = new FlowerinfoEntity();
        entity.setStock(100);
        entity.setPrice(new BigDecimal(10));
        entity.setCreated(LocalDateTime.now());
        String s = null;
        try {
            s = objectMapper.writeValueAsString(entity);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }
}
