package jp.cloudfree.motocatalog.beans;

import lombok.Data;

/**
 * 検索条件を保持するクラス
 */
@Data
public class SearchForm {

    // ブランドID
    private String brandId;
    // キーワード
    private String keyword;
}
