package com.cj.userModule.filter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author testjava
 * @since 2022-11-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysPermission对象", description="")
public class SysPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "资源名称")
    private String name;

    @ApiModelProperty(value = "资源类型：menu,button,")
    private String type;

    @ApiModelProperty(value = "访问url地址")
    private String url;

    @ApiModelProperty(value = "权限代码字符串")
    private String percode;

    @ApiModelProperty(value = "父结点id")
    private Long parentid;

    @ApiModelProperty(value = "父结点id列表串")
    private String parentids;

    @ApiModelProperty(value = "排序号")
    private String sortstring;

    @ApiModelProperty(value = "是否可用,1：可用，0不可用")
    private String available;


}
