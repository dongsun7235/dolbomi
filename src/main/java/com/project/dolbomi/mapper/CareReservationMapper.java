package com.project.dolbomi.mapper;


import com.project.dolbomi.domain.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.PropertyValues;

import java.util.List;

@Mapper
public interface CareReservationMapper {
    //    돌봄서비스 예약리스트
    public List<CareReservationVO> CareGetList(Long careReservationNum);
    //    돌봄서비스 예약하기
    public void insert(CareReservationVO careReservationVO);
    //    돌봄서비스 예약정보
    public CareReservationVO select(Long careReservationNum);


    //carereservation review list
    public List<CareReviewDTO> reviewGetListCare(String userEmail);

    //돌봄서비스 예약목록
    public List<CareReservationVO> getListCareReservation(Criteria criteria, List<String> areaAr);

    // care reservation 게시글 한개 가져오기
    public CareReservationVO selectCare(Long careReservationNum);

    // 돌봄서비스 예약자 1명 정보
    public CareReservationVO CareGet(Long careReservationNum);

    //돌봄서비스고객이 매니저 배정수락,user_userdetails 페이지의 돌봄예약목록
    public void CareManagerY(Long careReservationNum);
    // 돌봄서비스 매니저 배정 거절 user_userdetails페이지
    public void CareManagerN(Long careReservationNum);
    // 고객이 예약취소,user_userdetails2 페이지의 돌봄예약 취소
    public int Caredelete(Long careReservationNum);
    //돌봄서비스 매니저의 업무 시작,manager 페이지의 돌봄예약목록
    public void CareManagerStart(Long careReservationNum);
    //돌봄서비스 매니저의 업무 종료,manager 페이지의 돌봄예약목록
    public void CareManagerEnd(Long careReservationNum);
    //돌봄서비스 매니저가 업무 취소,manager 페이지의 돌봄예약목록
    public int CareManagerCancel(Long careReservationNum);
    // 돌봄서비스 예약자 1명 정보 status별
    public CareReservationVO caregetNum1(String userEmail);
    public User4CareDTO careManagerJoin(String userEmail);
    public User4CareDTO caregetNum2(String userEmail);
    public User4CareDTO caregetNum3(String userEmail);
    public CareReservationVO caregetNum4(String userEmail);
    //user_userdetails의 카운트 횟수.  CARE_RESERVATION_STATUS 에 따라 변경

    public int caregetTotal5(String userEmail);
    public int caregetTotal6(String userEmail);
    public int caregetTotal7(String userEmail);
    public int caregetTotal8(String userEmail);

    public int caregetManagerTotal6(String managerEmail);
    public int caregetManagerTotal7(String managerEmail);
    public int caregetManagerTotal8(String managerEmail);
    //유저 이메일로 매니저 예약메일 통해 매니저정보얻기
    public ManagerVO caregetManagerInfo(String userEmail);

    // 매니저가 서비스 신청한 돌봄예약내용 가져오기 status =0
    public CareReservationVO careManagerView(String managerEmail);

    // 매니저가 서비스 신청한 돌봄예약내용 가져오기 status =6
    public CareReservationVO careManagerView2(String managerEmail);

    public int caregetTotal5(Long careReservationNum);
    public int caregetTotal6(Long careReservationNum);
    public int caregetTotal7(Long careReservationNum);
    public int caregetTotal8(Long careReservationNum);

    public void CareReservationUpdate(@Param("careReservationNum") Long careReservationNum, @Param("managerEmail") String managerEmail);

    //user_details4 서비스 종료 리스트
    public List<User4CareDTO> careServiceEndList(String userEmail);

    //manager3 서비스 종료 리스트
    public List<CareReservationVO> careManagerServiceEndList(String managerEmail);

}
