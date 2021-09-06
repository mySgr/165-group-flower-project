package com.nf.flower.vo;


public class ResultVO {
    // 响应编码 :200 表示正常，-1 表示用户没有登陆....
    private Integer code;
    // 响应的 数据
    private Object data;
    // 响应的消息
    private String message;

    private ResultVO() {
    }


    public static ResultVO success(Object data, String message) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200);     // 设置 200 表示成功
        resultVO.setData(data);
        resultVO.setMessage(message);
        return resultVO;
    }

    public static ResultVO error(int code, String message) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMessage(message);
        return resultVO;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
