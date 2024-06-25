package com.example.thymeleaf;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.thymeleaf.entity.Point;
import com.example.thymeleaf.repository.PointRepository;

@SpringBootTest
class ThymeleafApplicationTests {

	@Autowired
	PointRepository pointRepository;

	// 내 주변 (반경 10km 이내) 장소만 출력 test
	@Test
	void contextLoads() {
		List<Point> list = pointRepository.findByLatLng(35.1576814559193, 129.182542912786, 35.1576814559193);
		System.out.println(list);
	}

}
