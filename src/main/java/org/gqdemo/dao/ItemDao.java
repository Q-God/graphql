package org.gqdemo.dao;

import org.gqdemo.entities.Item;
import org.gqdemo.entities.ItemList;
import org.gqdemo.entities.Param;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @version v1.0
 * @ClassName ItemDao
 * @Description TODO
 * @Author Q
 */

/**
 * 这里可以扩展持久化框架
 */
@Repository
public class ItemDao {

    private static final Map<Long, Item> ITEM_CACHE = new HashMap<>();

    static {
        ITEM_CACHE.put(1L, item(1L, "Java"));
        ITEM_CACHE.put(2L, item(2L, "C"));
        ITEM_CACHE.put(3L, item(3L, "C++"));
        ITEM_CACHE.put(4L, item(4L, "Kotlin"));
    }

    public ItemList queryItemList() {
        ItemList itemList = new ItemList();
        List<Item> items = ITEM_CACHE.values().stream().collect(Collectors.toList());
        itemList.setItemList(items);
        itemList.setTotal(ITEM_CACHE.size());
        return itemList;
    }

    public Item queryById(Long id) {
        return ITEM_CACHE.get(id);
    }

    public Item updateName(Param param) {
        Item item = ITEM_CACHE.get(param.getId());
        item.setName(param.getName());
        ITEM_CACHE.put(param.getId(), item);
        return ITEM_CACHE.get(param.getId());
    }

    private static Item item(long id, String code) {
        Item item = new Item();
        item.setId(id);
        item.setCode(code);
        item.setName(code + "项目");
        item.setCreateTime(System.currentTimeMillis());
        item.setSearchDate(new Date());
        return item;
    }
}
