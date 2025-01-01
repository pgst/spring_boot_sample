package jp.cloudfree.motocatalog.services;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jp.cloudfree.motocatalog.beans.Motorcycle;

@SpringBootTest
public class MotosServiceTest {
    
    @Autowired
    MotosService service;

    @Test
    void バイク情報を全件検索できるか() {
        
        List<Motorcycle> motos = service.getMotos();

        /* 検索結果の件数確認 */
        assertThat(motos).isNotNull(); // リストがnullでないことを確認
        assertThat(motos.size()).isEqualTo(5);

        /* 検索結果の各項目の確認 */
        Motorcycle moto = motos.get(0); // 1件目のデータを取得
        assertThat(moto).isNotNull(); // データがnullでないことを確認
        assertThat(moto.getMotoNo()).isEqualTo(1);
        assertThat(moto.getMotoName()).isEqualTo("DAX125");
        assertThat(moto.getPrice()).isEqualTo(440000);
    }
}
