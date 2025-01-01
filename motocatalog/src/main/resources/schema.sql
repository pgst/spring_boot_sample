DROP TABLE IF EXISTS `m_motorcycle`;
CREATE TABLE `m_motorcycle` (
    `moto_no` int NOT NULL COMMENT 'バイク番号',
    `moto_name` varchar(100) COMMENT 'バイク名',
    `seat_height` int COMMENT 'シート高',
    `cylinder` int COMMENT 'シリンダー',
    `cooling` varchar(20) COMMENT '冷却',
    `price` int COMMENT '価格',
    `comment` varchar(200) COMMENT 'コメント',
    `brand_id` varchar(2) COMMENT 'ブランドID',
    `version` int COMMENT 'バージョン',
    `ins_dt` datetime COMMENT '登録日時',
    `upd_dt` datetime COMMENT '更新日時'
) COMMENT 'モーターサイクルマスタ';

DROP TABLE IF EXISTS `m_brand`;
CREATE TABLE `m_brand` (
    `brand_id` varchar(2) NOT NULL COMMENT 'ブランドID',
    `brand_name` varchar(20) COMMENT 'ブランド名'
) COMMENT 'ブランドマスタ';