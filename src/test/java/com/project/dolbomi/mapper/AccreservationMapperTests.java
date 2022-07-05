package com.project.dolbomi.mapper;

import com.project.dolbomi.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class AccreservationMapperTests {
    @Autowired
    private AccReservationMapper accReservationMapper;


    /*@Test
    public void getListTest() {
        accReservationMapper.getList().stream().map(AccReservationVO::toString).forEach(log::info);
    }*/

    /*@Test
    public void insertTests(){
        AccReservationVO accReservationVO = new AccReservationVO();

        accReservationVO.setAccReservationPhoneNum("01054719297");
        accReservationVO.setAccReservationAddRequire("잘 봐주세요!");
        accReservationVO.setAccReservationEndAddress("서울시");
        accReservationVO.setAccReservationStartAddress("수원시");
        accReservationVO.setAccReservationAge("11");
        accReservationVO.setAccReservationTime("2");
        accReservationVO.setUserEmail("dpple");
        accReservationVO.setAccReservationName("강감찬");
        accReservationVO.setAccReservationAddPhoneNum("010012129312");
        accReservationVO.setAccReservationDate("2022-02-21-12-00");
        accReservationVO.setAccReservationGender("M");
        accReservationVO.setAccReservationHopeGender("M");
        accReservationVO.setAccReservationPrice("4000");
        accReservationVO.setAccReservationType("기타동행");
        accReservationVO.setAccReservationRelation("아버지");

        accReservationMapper.insert(accReservationVO);
    }*/
    @Test
    public void as(){
        accReservationMapper.accgetManagerInfo("김동행@naver.com");


    }

/*
    @Test
    public void select() {
        log.info(accReservationMapper.AccGetList(9L).toString());
    }
*/
    @Test
    public void listTest(){
        List<String> areaAr = new ArrayList<>();
        areaAr.add("서울 강남구");
        log.info(accReservationMapper.getListAccReservation(new Criteria(), areaAr).toString());
    }
//    @Test
//    public void select() {
//        log.info(accReservationMapper.AccGetList(9L).toString());
//    }

    @Test
    public void AccReservationUpdate(){
        accReservationMapper.AccReservationUpdate(44L, "APPLE");
    }

    @Test
    public void bigTest(){
        accReservationMapper.accManagerJoin("aaa@naver.com");
    }
}