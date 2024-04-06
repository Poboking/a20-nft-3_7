package org.knight.app.biz.artwork.dto.holdcollection;

import lombok.*;
import org.knight.app.biz.artwork.dto.collection.CollectionBaseDTO;
import org.knight.app.biz.artwork.dto.mysteryBox.SubCommodityRespDTO;

import java.util.List;

/**
 * @project: a20-nft-3_7
 * @author: poboking
 * @date: 2024/4/1 17:37
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyHoldCollectionDetailRespDTO extends CollectionBaseDTO {

    private String id;

    private String issuedCollectionId;

    private String lockPayMemberId;

    private String commodityType;

    private Double resalePrice;

    private String collectionName;

    private String collectionCover;

    private Integer quantity;

    private Integer collectionSerialNumber;

    private String uniqueId;

    private String collectionHash;

    private String transactionHash;

    private String creatorId;

    private String creatorAvatar;

    private String creatorName;

    private String holderNickName;

    private String holderAvatar;

    private String holderBlockChainAddr;

    private List<String> storyPicLinks;

    private List<SubCommodityRespDTO> subCommoditys;
}
