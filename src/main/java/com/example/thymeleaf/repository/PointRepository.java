package com.example.thymeleaf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.thymeleaf.entity.Point;

public interface PointRepository extends JpaRepository<Point, Integer> {
    // nativeQuery = true : 내가 작성하는 쿼리임을 알리기
    @Query(nativeQuery = true,
            // value = "SELECT *,"
            //         + " (6371 * acos("
            //                     + " cos(radians(?1))"
            //                     + " * cos(radians(lat))"
            //                     + " * cos(radians(lng) - radians(?2))"
            //                     + " + sin(radians(?3))"
            //                     + " * sin(radians(lat)))) AS distance"
            //         + " FROM point"
            //         + " WHERE distance <= 10"
            //         + " ORDER BY distance")
            // mariadb는 HAVING 사용해야함 / sqllite는 WHERE 사용해야함
            value = "SELECT * FROM (SELECT *,"
                                    + " (6371 * acos("
                                                    + " cos(radians(?1))"
                                                    + " * cos(radians(lat))"
                                                    + " * cos(radians(lng) - radians(?2))"
                                                    + " + sin(radians(?3))"
                                                    + " * sin(radians(lat)))) AS distance"
                                    + " FROM point)"
                                    + " WHERE distance <= 10")
    public List<Point> findByLatLng(double lat, double lng, double lat2);
}
