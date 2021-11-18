package org.gqdemo.service;

import org.gqdemo.entities.Item;
import org.gqdemo.entities.ItemList;
import org.gqdemo.entities.Param;

/**
 * @version v1.0
 * @ClassName Service
 * @Description TODO
 * @Author Q
 */
public interface ItemService {

    ItemList queryItemList();

    Item queryById(Long id);

    Item updateName(Param param);
}
