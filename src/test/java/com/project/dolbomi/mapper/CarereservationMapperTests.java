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
public class CarereservationMapperTests {
    @Autowired
    private CareReservationMapper careReservationMapper;


    /*@Test
    public void getListTest() {
        careReservationMapper.CareGetList().stream().map(CareReservationVO::toString).forEach(log::info);
    }*/

    /*@Test
    public void insertTest(){
        CareReservationVO careReservationVO = new CareReservationVO();

        careReservationVO.setCareReservationType("아이돌봄");
        careReservationVO.setCareReservationName("이순신");
        careReservationVO.setCareReservationAge("7");
        careReservationVO.setCareReservationPhoneNum("01012341234");
        careReservationVO.setCareReservationGender("W");
        careReservationVO.setCareReservationAddPhoneNum("01023452345");
        careReservationVO.setCareReservationRelation("어머니");
        careReservationVO.setCareReservationAddress("서울특별시");
        careReservationVO.setCareReservationHopeGender("W");
        careReservationVO.setCareReservationDate("2022-03-12-15-20");
        careReservationVO.setCareReservationTime("4");
        careReservationVO.setCareReservationAddRequire("잘부탁드립니다.");
        careReservationVO.setCareReservationPrice("20000");
        careReservationVO.setUserEmail("dpple");

        careReservationMapper.insert(careReservationVO);
    }*/


/*
    @Test
    public void selectTest(){
        log.info(careReservationMapper.CareGetList(7L).toString());
    }
*/
/*
    @Test
    public void delete(){
        log.info(String.valueOf(careReservationMapper.delete(3L)));
    }
*/
    @Test
    public void listTest(){
        List<String> areaAr = new ArrayList<>();

        log.info(careReservationMapper.getListCareReservation(new Criteria(), areaAr).toString());
    }
//    @Test
//    public void delete(){
//        log.info(String.valueOf(careReservationMapper.delete(3L)));
//    }

    @Test
    public void endListTests(){
        log.info(careReservationMapper.careServiceEndList("APPLE").toString());
    }
//    @Test
//    public void CareReservationUpdate(){
//        careReservationMapper.CareReservationUpdate(26L, "APPLE");
//    }


    @Test
    public void secondList(){
        careReservationMapper.careManagerView2("apple@naver.com");
    }

}
