package org.knight.app.biz.dict.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @project: a20-nft-3_7
 * @author: poboking
 * @date: 2024/3/10 19:05
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DictItemRespDTo {

    private String dictItemName;

    private String dictItemCode;
}
