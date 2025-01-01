INSERT INTO m_motorcycle (moto_no, moto_name, seat_height, cylinder, cooling, price, comment, brand_id, version, ins_dt, upd_dt) VALUES (1, 'DAX125', 775, 1, '空冷', 440000, 'ホンダのレトロバイク', '01', 1, NULL, NULL);
INSERT INTO m_motorcycle (moto_no, moto_name, seat_height, cylinder, cooling, price, comment, brand_id, version, ins_dt, upd_dt) VALUES (2, 'VanVan', 770, 1, '空冷', 400000, 'スズキのレトロバイク', '02', 1, NULL, NULL);
INSERT INTO m_motorcycle (moto_no, moto_name, seat_height, cylinder, cooling, price, comment, brand_id, version, ins_dt, upd_dt) VALUES (3, 'Super Cub', 735, 1, '空冷', 250000, 'ホンダのスーパーカブ', '01', 1, NULL, NULL);
INSERT INTO m_motorcycle (moto_no, moto_name, seat_height, cylinder, cooling, price, comment, brand_id, version, ins_dt, upd_dt) VALUES (4, 'Z900RS', 800, 4, '水冷', 1200000, 'カワサキのネオクラシックバイク', '04', 1, NULL, NULL);
INSERT INTO m_motorcycle (moto_no, moto_name, seat_height, cylinder, cooling, price, comment, brand_id, version, ins_dt, upd_dt) VALUES (5, 'SR400', 785, 1, '空冷', 600000, 'ヤマハのレトロバイク', '03', 1, NULL, NULL);

-- バイクメーカーのデータ
INSERT INTO m_brand (brand_id, brand_name) VALUES ('01', 'ホンダ');
INSERT INTO m_brand (brand_id, brand_name) VALUES ('02', 'スズキ');
INSERT INTO m_brand (brand_id, brand_name) VALUES ('03', 'ヤマハ');
INSERT INTO m_brand (brand_id, brand_name) VALUES ('04', 'カワサキ');