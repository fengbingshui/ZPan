package com.zhu.pan.core.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

/**
 * 公用返回对象
 */
// 保证json序列化的时候，如果属性为null，key也就一起消失
//jackson Java 对象如何序列化为 JSON
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class R<T> implements Serializable {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态说明文案
     */
    private String message;

    /**
     * 返回承载
     */
    private T data;

    private R(Integer code) {
        this.code = code;
    }

    private R(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private R(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @JsonIgnore
    @JSONField(serialize = false)
    /**
     * 当这两个注解同时出现在同一个字段或方法上时，它们会共同作用，
     * 确保在不同的 JSON 序列化库（Jackson 和 FastJSON）中都忽略该字段或方法。简而言之：
        @JsonIgnore 会使 Jackson 忽略该字段。
        @JSONField(serialize = false) 会使 FastJSON 忽略该字段。
     * @return
     */
    public boolean isSuccess() {
        return Objects.equals(this.code, ResponseCode.SUCCESS.getCode());
    }

    public static <T> R<T> success() {
        return new R<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> R<T> success(String message) {
        return new R<T>(ResponseCode.SUCCESS.getCode(), message);
    }

    public static <T> R<T> data(T data) {
        return new R<T>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getDesc(), data);
    }

    public static <T> R<T> fail() {
        return new R<T>(ResponseCode.ERROR.getCode());
    }

    public static <T> R<T> fail(String message) {
        return new R<T>(ResponseCode.ERROR.getCode(), message);
    }

    public static <T> R<T> fail(Integer code, String message) {
        return new R<T>(code, message);
    }

    public static <T> R<T> fail(ResponseCode responseCode) {
        return new R<T>(responseCode.getCode(), responseCode.getDesc());
    }

}
