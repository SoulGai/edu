package top.testeru.edu.common.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @program: edu
 * @author: 盖盖
 * @description:
 * @Date: 2023/11/19
 */
@Getter
@Setter
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    //状态码
    private int code;
    //状态信息
    private String message;
    //业务返回数据
    private T data;

    private R(){}
    public R(int code) {
        this.code = code;
    }
    public R(ResultEnum resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public R(ResultEnum resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }
    public static <T> R<T> success(){
        return new R<>(ResultEnum.SUCCESS, (T)new HashMap<>());
    }

    public static <T> R<T> success(T content){
        return new R<>(ResultEnum.SUCCESS, content);
    }

    public static <T> R<T> ofError(ResultEnum resultCode){
        return new R<>(resultCode, (T)new HashMap<>());
    }

    public static <T> R<T> ofError(ResultEnum resultCode, T content){
        return new R<>(resultCode, content);
    }

    public R<T> status(int code){
        this.setCode(code);
        return this;
    }

    public R<T> message(String message){
        this.setMessage(message);
        return this;
    }
    public R<T> data(T value){
        this.setData(value);
        return this;
    }
}
