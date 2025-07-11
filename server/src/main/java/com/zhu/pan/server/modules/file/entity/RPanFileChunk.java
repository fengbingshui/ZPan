package com.zhu.pan.server.modules.file.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 文件分片信息表
 * @TableName r_pan_file_chunk
 */
@TableName(value ="r_pan_file_chunk")
@Data
public class RPanFileChunk {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 文件唯一标识
     */
    @TableField(value = "identifier")
    private String identifier;

    /**
     * 分片真实的存储路径
     */
    @TableField(value = "real_path")
    private String real_path;

    /**
     * 分片编号
     */
    @TableField(value = "chunk_number")
    private Integer chunk_number;

    /**
     * 过期时间
     */
    @TableField(value = "expiration_time")
    private Date expiration_time;

    /**
     * 创建人
     */
    @TableField(value = "create_user")
    private Long create_user;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date create_time;
}