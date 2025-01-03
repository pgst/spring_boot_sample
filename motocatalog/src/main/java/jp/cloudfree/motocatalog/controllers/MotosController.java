package jp.cloudfree.motocatalog.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.slf4j.LoggerFactory;  // @Slf4jで解決するのでimport不要
// import org.slf4j.Logger;         // @Slf4jで解決するのでimport不要
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.cloudfree.motocatalog.beans.Brand;
import jp.cloudfree.motocatalog.beans.Motorcycle;
import jp.cloudfree.motocatalog.beans.SearchForm;
import jp.cloudfree.motocatalog.services.MotosService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j  // 変数logを使用できるようになる
public class MotosController {
    
    // ログ部品を使用できるようになる
    // private static final Logger log = LoggerFactory.getLogger(MotosController.class);

    @Autowired
    MotosService service;

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", required = false) String name, Model model) {

        model.addAttribute("name", name);
        return "test";
    }

    /**
     * バイク一覧を表示する
     * @param searchForm
     * @param model
     * @return 遷移先
     */
    @GetMapping("/motos")
    public String motos(SearchForm searchForm, Model model) {

        log.info("検索条件: {}", searchForm);
        
        // ブランドリストを準備
        this.setBrands(model);

        // バイク
        List<Motorcycle> motos = new ArrayList<>();
        motos = service.getMotos(searchForm);

        model.addAttribute("motos", motos);

        log.debug("motos: {}", motos); // slf4jのlogを使用

        return "moto_list";
    }
    
    /**
     * 検索条件をクリアする
     * @param searchForm
     * @param model
     * @return 遷移先
     */
    @GetMapping("/motos/reset")
    public String reset(SearchForm searchForm, Model model) {

        // ブランドリストを準備
        this.setBrands(model);

        /* 検索条件のクリア */
        searchForm = new SearchForm();
        return "moto_list";
    }

    /**
     * ブランドリストを取得してModelにセットする
     * @param model
     */
    private void setBrands(Model model) {

        // ブランド
        List<Brand> brands = new ArrayList<>();
        brands = service.getBrands();
        model.addAttribute("brands", brands);
    }
}
