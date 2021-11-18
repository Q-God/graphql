package org.gqdemo.entities;

import lombok.Data;

import java.util.List;

/**
 * @version v1.0
 * @ClassName ItemList
 * @Description TODO
 * @Author Q
 */
@Data
public class ItemList {

    private List<Item> itemList;

    private int total;
}
