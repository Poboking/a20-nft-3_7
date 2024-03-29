package org.knight.app.biz.artwork.dto.collection;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.*;

/**
 * @project: a20-nft-3_7
 * @author: poboking
 * @date: 2024/3/9 21:18
 */
@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CollectionQueryReqDTO extends CollectionBaseDTO {

    private Long pageSize;

    private Long current;

    private String commodityType;

    private String creatorId;

    private String collectionId;

    private String direction;

    @Hidden
    public boolean isOrderDesc() {
        return "desc".equalsIgnoreCase(direction);
    }
}
