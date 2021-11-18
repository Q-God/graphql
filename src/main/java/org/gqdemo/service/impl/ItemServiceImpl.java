package org.gqdemo.service.impl;

import org.gqdemo.dao.ItemDao;
import org.gqdemo.entities.Item;
import org.gqdemo.entities.ItemList;
import org.gqdemo.entities.Param;
import org.gqdemo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version v1.0
 * @ClassName ItemServiceImpl
 * @Description TODO
 * @Author Q
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Override
    public ItemList queryItemList() {
        return itemDao.queryItemList();
    }

    @Override
    public Item queryById(Long id) {
        return itemDao.queryById(id);
    }

    @Override
    public Item updateName(Param param) {
        return updateName(param);
    }
}
