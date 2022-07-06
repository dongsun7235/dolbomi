package com.project.dolbomi.mapper;

import com.project.dolbomi.domain.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AccReservationMapper {




    //    동행서비스 예약하기
    public void insert(AccReservationVO accReservationVO);
    //    동행서비스 예약정보확인
    public AccReservationVO select(Long accReservationNum);


    public List<AccReservationVO> AccResult(String accReservationName);

    public void insertmanagerEmail(String accReservationVO);

    // acc reservation 게시글 목록
    public List<AccReviewDTO> reviewGetListAcc(String userEmail);

    //동행서비스 예약 목록
    public List<AccReservationVO> getListAccReservation(@Param("criteria") Criteria criteria, @Param("areaAr") List<String> areaAr);

    // acc reservation 게시글 한개 가져오기
    public AccReservationVO selectAcc(Long accReservationNum);


    // 동행서비스 예약자 1명 정보
    public AccReservationVO AccGet(Long accReservationNum);


    //동행서비스고객이 매니저 배정수락,user_userdetails 페이지의 동행예약목록
    public void AccManagerY(Long accReservationNum);
    // 동행서비스 매니저 배정 거절 user_userdetails페이지
    public void AccManagerN(Long accReservationNum);
    // 고객이 예약취소,user_userdetails2 페이지의 동행예약 취소
    public int Accdelete(Long accReservationNum);
    //동행서비스 매니저의 업무 시작,manager 페이지의 동행예약목록
    public void AccManagerStart(Long accReservationNum);
    //동행서비스 매니저의 업무 종료,manager 페이지의 동행예약목록
    public void AccManagerEnd(Long accReservationNum);
    //동행서비스 매니저가 업무 취소,manager 페이지의 동행예약목록
    public int AccManagerCancel(Long accReservationNum);
    // 동행서비스 예약자 1명 정보, status=0
    public AccReservationVO accgetNum1(String userEmail);
    public User4AccDTO accManagerJoin(String userEmail);
    public User4AccDTO accgetNum2(String userEmail);
    public User4AccDTO accgetNum3(String userEmail);
    public AccReservationVO accgetNum4(String userEmail);
    //user_userdetails의 카운트 횟수.  ACC_RESERVATION_STATUS 에 따라 변경

    // 매니저가 서비스 신청한 동행예약내용 가져오기 status =0
    public AccReservationVO accManagerView(String managerEmail);

    // 매니저가 서비스 신청한 돌봄예약내용 가져오기 status =6
    public AccReservationVO accManagerView2(String managerEmail);

    public int accgetTotal1(String userEmail);
    public int accgetTotal2(String userEmail);
    public int accgetTotal3(String userEmail);
    public int accgetTotal4(String userEmail);
    //유저 이메일로 매니저 예약메일 통해 매니저정보얻기
    public ManagerVO accgetManagerInfo(String userEmail);

    public int accgetTotal1(Long accReservationNum);
    public int accgetTotal2(Long accReservationNum);
    public int accgetTotal3(Long accReservationNum);
    public int accgetTotal4(Long accReservationNum);

    public void AccReservationUpdate(@Param("accReservationNum") Long accReservationNum, @Param("managerEmail") String managerEmail);

    //user_details4 서비스 종료 리스트
    public List<User4AccDTO> accServiceEndList(String userEmail);

    //manager3 서비스 종료 리스트
    public List<AccReservationVO> accManagerServiceEndList(String managerEmail);
}

