package com.switchfully.order.api.mapper;

import com.switchfully.order.domain.order.ItemGroup;
import com.switchfully.order.domain.order.ItemGroupDto;
import org.springframework.stereotype.Component;

@Component
public class ItemGroupMapper {

    public ItemGroupDto mapToDto(ItemGroup itemGroup){
        return new ItemGroupDto()
                .setItemId(itemGroup.getItemId())
                .setAmount(itemGroup.getAmount())
                .setShippingDate(itemGroup.getShippingDate());

    }

    public ItemGroup mapToDomain(ItemGroupDto itemGroupDto){
        return new ItemGroup(itemGroupDto.getItemId(), itemGroupDto.getAmount(), itemGroupDto.getShippingDate());
    }
}
