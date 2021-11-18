package org.gqdemo.entities;

import lombok.Data;

import java.util.Date;

/**
 * @version v1.0
 * @ClassName Item
 * @Description TODO
 * @Author Q
 */
@Data
public class Item {

    private long id;

    private String name;

    private String code;

    private Long createTime;

    private Date searchDate;
}
