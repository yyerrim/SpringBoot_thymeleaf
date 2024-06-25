package com.example.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.thymeleaf.entity.Point;
import com.example.thymeleaf.repository.PointRepository;

@Controller
public class MapController {
    // @GetMapping("/map")
    // public String map() {
    //     return "map";
    // }

    @Autowired
    PointRepository pointRepository;

    @GetMapping("/map")
    public String map(Model model) {
        List<Point> list = pointRepository.findAll();

        // // 내 주변 (반경 10km 이내) 장소만 출력
        // List<Point> list = pointRepository.findByLatLng(0, 0, 0);
        // // 주소로 접속할때 내 위치 정보 넘기기 못함

        model.addAttribute("list", list);
        return "map";
    }

    @GetMapping("/map2")
    public String map2() {
        return "map2";
    }

    // @GetMapping("/map2/data")
    // @ResponseBody
    // public List<Point> map2Data() {
    //     List<Point> list = pointRepository.findAll();
    //     return list;
    // }

    @GetMapping("/map2/data")
    @ResponseBody
    public List<Point> map2Data(
            @RequestParam Double lat, @RequestParam Double lng) {
        // 내 주변 (반경 10km 이내) 장소만 출력
        List<Point> list = pointRepository.findByLatLng(lat, lng, lat);
        // 주소로 접속할때 내 위치 정보 넘기기 가능 (맵 껍데기를 열어주고 fetch로 데이터를 가져오기때문)
        return list;
    }
}
