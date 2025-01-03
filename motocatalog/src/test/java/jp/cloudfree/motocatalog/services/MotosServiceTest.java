package jp.cloudfree.motocatalog.services;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import jp.cloudfree.motocatalog.beans.Motorcycle;
import jp.cloudfree.motocatalog.beans.SearchCondition;

@SpringBootTest
public class MotosServiceTest {
    
    @Autowired
    MotosService service;

    // @Test
    // void バイク情報を全件検索できるか() {

    //     SearchCondition condition = new SearchCondition();
    //     List<Motorcycle> motos = service.getMotos(condition);

    //     /* 検索結果の件数確認 */
    //     assertThat(motos).isNotNull(); // リストがnullでないことを確認
    //     assertThat(motos.size()).isEqualTo(5);

    //     /* 検索結果の各項目の確認 */
    //     Motorcycle moto = motos.get(0); // 1件目のデータを取得
    //     assertThat(moto).isNotNull(); // データがnullでないことを確認
    //     assertThat(moto.getMotoNo()).isEqualTo(1);
    //     assertThat(moto.getMotoName()).isEqualTo("DAX125");
    //     assertThat(moto.getPrice()).isEqualTo(440000);
    // }
    

    @DisplayName("バイク一覧取得 条件: ブランドID")
    @ParameterizedTest
    @CsvSource({
        "01, ホンダ",
        "02, スズキ",
        "03, ヤマハ"
    })
    void test001(String brandId, String brandName) {

        SearchCondition condition = new SearchCondition();
        condition.setBrandId(brandId);
        List<Motorcycle> motos = service.getMotos(condition);

        assertThat(motos.size()).isGreaterThanOrEqualTo(1);  // 1件以上

        for (Motorcycle moto : motos) {
            assertThat(moto.getBrand().getBrandName()).isEqualTo(brandName);
        }
    }

    @DisplayName("バイク一覧取得 条件: ブランドID 該当なし")
    @Test
    void test002() {

        SearchCondition condition = new SearchCondition();
        condition.setBrandId("99");
        List<Motorcycle> motos = service.getMotos(condition);

        assertThat(motos.size()).isEqualTo(0); // 0件
    }
    
    @DisplayName("バイク一覧取得 条件: バイク名-完全一致")
    @ParameterizedTest
    @CsvSource({"DAX125", "VanVan"})
    void test003(String motoName) {

        SearchCondition condition = new SearchCondition();
        condition.setKeyword(motoName);
        List<Motorcycle> motos = service.getMotos(condition);

        assertThat(motos.size()).isGreaterThanOrEqualTo(1); // 1件以上

        for (Motorcycle moto : motos) {
            assertThat(moto.getMotoName()).isEqualTo(motoName);
        }
    }
    
    @DisplayName("バイク一覧取得 条件: バイク名-部分一致")
    @ParameterizedTest
    @CsvSource({"DAX, DAX125", "an, VanVan", "X12, DAX125"})
    void test004(String keyword, String motoName) {

        SearchCondition condition = new SearchCondition();
        condition.setKeyword(keyword);
        List<Motorcycle> motos = service.getMotos(condition);

        assertThat(motos.size()).isGreaterThanOrEqualTo(1); // 1件以上

        for (Motorcycle moto : motos) {
            assertThat(moto.getMotoName()).isEqualTo(motoName);
        }
    }

    @DisplayName("バイク情報更新")
    @Test
    @Transactional  // テストメソッドの実行後にロールバックする（必須）
    // @Rollback       // テストメソッドの実行後にロールバックする（デフォルト）
    void test011() {

        Motorcycle before = service.getMotos(1); // 更新前のデータを取得
        before.setMotoName("DAX125改");

        service.save(before);  // 更新（保存）

        Motorcycle after = service.getMotos(1);  // 更新後のデータを取得
        assertThat(after.getMotoName()).isEqualTo("DAX125改");
        assertThat(after.getVersion()).isEqualTo(before.getVersion() + 1);
    }
}
