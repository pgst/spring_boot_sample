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

    @GetMapping("/motos")
    public String motos(Model model) {
        // ブランド
        List<Brand> brands = new ArrayList<>();
        // brands.add(new Brand("01", "HONDA"));
        // brands.add(new Brand("02", "kAWASAKI"));
        // brands.add(new Brand("03", "YAMAHA"));
        // brands.add(new Brand("04", "SUZUKI"));
        brands = service.getBrands();

        // バイク
        List<Motorcycle> motos = new ArrayList<>();
        // motos.add(new Motorcycle(1, "GB350", 800, 1, "空冷", 500000, "いい音", new Brand("01", "HONDA"), 1, null, null));
        // motos.add(new Motorcycle(2, "Ninja", 800, 2, "水冷", 1000000, "すいすい", new Brand("02", "KAWASAKI"), 1, null, null));
        // motos.add(new Motorcycle(3, "Z900RS CAFE", 820, 4, "水冷", 1380000, "音めちゃうるさい", new Brand("02", "KAWASAKI"), 1, null, null));
        motos = service.getMotos();

        model.addAttribute("brands", brands);
        model.addAttribute("motos", motos);

        log.debug("motos: {}", motos);  // slf4jのlogを使用
        
        return "moto_list";
    }
}
