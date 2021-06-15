package com.nf.flower.entity.commodity;

/**
 *  鲜花图片
 *CREATE TABLE flower_picture(
         *picture_id INT PRIMARY KEY AUTO_INCREMENT,    #鲜花图片编号
         *flower_id INT,                            #鲜花编号
         *img_url VARCHAR(128)                    #图片路径
         *);
 */
public class FlowerPictureEntity {
    private Integer pictureId;
    private Integer FlowerId;
    private String imgUrl;

    private FlowerinfoEntity flowerEntity;

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public Integer getFlowerId() {
        return FlowerId;
    }

    public void setFlowerId(Integer flowerId) {
        FlowerId = flowerId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public FlowerinfoEntity getFlowerEntity() {
        return flowerEntity;
    }

    public void setFlowerEntity(FlowerinfoEntity flowerEntity) {
        this.flowerEntity = flowerEntity;
    }


    @Override
    public String toString() {
        return "FlowerPictureEntity{" +
                "pictureId=" + pictureId +
                ", FlowerId=" + FlowerId +
                ", imgUrl='" + imgUrl + '\'' +
                ", flowerEntity=" + flowerEntity +
                '}';
    }
}
