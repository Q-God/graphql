package org.gqdemo.graphql.resolver;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.gqdemo.entities.Item;
import org.gqdemo.entities.ItemList;
import org.gqdemo.entities.Param;
import org.gqdemo.service.ItemService;

/**
 * @version v1.0
 * @ClassName ItemResolver
 * @Description TODO
 * @Author Q
 */
public class ItemResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    private ItemService itemService;

    public ItemResolver(ItemService itemService) {
        this.itemService = itemService;
    }


    public ItemList queryItemList() {
        return itemService.queryItemList();
    }

    public Item queryById(Long id) {
        return itemService.queryById(id);
    }

    public Item updateName(Param param) {
        return itemService.updateName(param);
    }
}
