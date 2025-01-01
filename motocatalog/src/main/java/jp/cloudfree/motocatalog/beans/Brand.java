package jp.cloudfree.motocatalog.beans;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * バイクメーカー（ブランド）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
    
    // ブランドID
    private String brandId;
    // ブランド名
    private String brandName;
}
