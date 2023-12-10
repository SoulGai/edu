package top.testeru.ad.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author gai
 * @since 2023-12-10
 */
@Getter
@Setter
@TableName("promotion_ad")
//@ApiModel(value = "PromotionAd对象", description = "")
public class PromotionAd implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //@ApiModelProperty("广告名")
    private String name;

    //@ApiModelProperty("广告位id")
    private Integer spaceId;

    //@ApiModelProperty("精确搜索关键词")
    private String keyword;

    //@ApiModelProperty("静态广告的内容")
    private String htmlContent;

    //@ApiModelProperty("文字一")
    private String text;

    //@ApiModelProperty("链接一")
    private String link;

    //@ApiModelProperty("开始时间")
    private LocalDateTime startTime;

    //@ApiModelProperty("结束时间")
    private LocalDateTime endTime;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer status;

    //@ApiModelProperty("优先级")
    private Integer priority;

    private String img;
}
