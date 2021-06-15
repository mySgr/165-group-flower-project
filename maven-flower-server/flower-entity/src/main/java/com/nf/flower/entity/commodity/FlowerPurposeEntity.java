package com.nf.flower.entity.commodity;

/**
 * -- 鲜花用途
 * CREATE TABLE flower_purpose(
 * purpose_id INT AUTO_INCREMENT COMMENT '编号',
 * purpose_name VARCHAR(50) COMMENT '用途名称',
 * PRIMARY KEY(purpose_id)
 * )
 */
public class FlowerPurposeEntity {
    private Integer purposeId;
    private String purposeName;

    public Integer getPurposeId() {
        return purposeId;
    }

    public void setPurposeId(Integer purposeId) {
        this.purposeId = purposeId;
    }

    public String getPurposeName() {
        return purposeName;
    }

    public void setPurposeName(String purposeName) {
        this.purposeName = purposeName;
    }

    @Override
    public String toString() {
        return "FlowerPurposeEntity{" +
                "purposeId=" + purposeId +
                ", purposeName='" + purposeName + '\'' +
                '}';
    }
}
