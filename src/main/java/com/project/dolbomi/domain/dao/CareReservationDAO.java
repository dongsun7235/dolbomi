package com.project.dolbomi.domain.dao;

import com.project.dolbomi.domain.vo.*;
import com.project.dolbomi.mapper.CareReservationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CareReservationDAO {
    private final CareReservationMapper careReservationMapper;

    //    돌봄서비스 예약리스트
    public List<CareReservationVO> CareGetList(Long careReservationNum) {
        return careReservationMapper.CareGetList(careReservationNum)  ;
    }

    //    돌봄서비스 예약하기
    public void careReservation(CareReservationVO careReservationVO) {
        careReservationMapper.insert(careReservationVO);
    }

    // carereservation review list
    public List<CareReviewDTO> reviewGetListCare(String userEmail) {
        return careReservationMapper.reviewGetListCare(userEmail);
    }

    //    돌봄서비스 리스트
    public List<CareReservationVO> getListCareReservation(Criteria criteria, List<String> areaAr) {
        return careReservationMapper.getListCareReservation(criteria, areaAr);
    }

    // carereservation select one
    public CareReservationVO selectCare(Long careReservationNum) {
        return careReservationMapper.selectCare(careReservationNum);
    }

    //    돌봄서비스 예약정보
    public void careReservationInfo(Long careReservationNum) {
    }

    // 돌봄서비스 매니저 배정 수락 user_userdetails페이지
    public void CareManagerY(Long accReservationNum){
        careReservationMapper.CareManagerY(accReservationNum) ;
    }
    // 돌봄서비스 매니저 배정 거절 user_userdetails페이지
    public void CareManagerN(Long accReservationNum){
        careReservationMapper.CareManagerN(accReservationNum);
    }

    // 돌봄서비스고객이 예약취소,user_userdetails2 페이지의 동행예약 취소
    public void Caredelete(Long careReservationNum){
        careReservationMapper.Caredelete(careReservationNum);
    }

    //돌봄서비스 매니저의 업무 시작,manager 페이지의 동행예약목록
    public void CareManagerStart(Long accReservationNum){
        careReservationMapper.CareManagerStart(accReservationNum) ;
    }
    //돌봄서비스 매니저의 업무 종료,manager 페이지의 동행예약목록
    public void CareManagerEnd(Long accReservationNum){
        careReservationMapper.CareManagerEnd(accReservationNum);
    }

    //돌봄서비스 매니저가 업무 취소,manager 페이지의 동행예약목록
    public void CareManagerCancel(Long accReservationNum){
        careReservationMapper.CareManagerCancel(accReservationNum);
    }
    //    동행서비스 예약자 1명 정보
    public CareReservationVO CareGet(Long careReservationNum){
        return careReservationMapper.CareGet(careReservationNum)  ;
    }

    public CareReservationVO caregetNum1(String userEmail){ return careReservationMapper.caregetNum1(userEmail);}
    public User4CareDTO careManagerJoin(String userEmail){return careReservationMapper.careManagerJoin(userEmail);}
    public User4CareDTO caregetNum2(String userEmail){ return careReservationMapper.caregetNum2(userEmail);}
    public User4CareDTO caregetNum3(String userEmail){ return careReservationMapper.caregetNum3(userEmail);}
    public CareReservationVO caregetNum4(String userEmail){ return careReservationMapper.caregetNum4(userEmail);}

    public int caregetTotal5(String userEmail){return careReservationMapper.caregetTotal5(userEmail); }
    public int caregetTotal6(String userEmail){
        return careReservationMapper.caregetTotal6(userEmail);
    }
    public int caregetTotal7(String userEmail){
        return careReservationMapper.caregetTotal7(userEmail);
    }
    public int caregetTotal8(String userEmail){
        return careReservationMapper.caregetTotal8(userEmail);
    }

    public int caregetManagerTotal6(String managerEmail){
        return careReservationMapper.caregetManagerTotal6(managerEmail);
    }
    public int caregetManagerTotal7(String managerEmail){
        return careReservationMapper.caregetManagerTotal7(managerEmail);
    }
    public int caregetManagerTotal8(String managerEmail){
        return careReservationMapper.caregetManagerTotal8(managerEmail);
    }
    //유저 이메일로 매니저 예약메일 통해 매니저정보얻기
    public ManagerVO caregetManagerInfo(String userEmail){return careReservationMapper.caregetManagerInfo(userEmail);}

    //동행 서비스 매니저 연결,status 0
    public CareReservationVO careManagerView(String managerEmail){return careReservationMapper.careManagerView(managerEmail);}

    //동행 서비스 매니저 연결,status 6
    public CareReservationVO careManagerView2(String managerEmail){return careReservationMapper.careManagerView2(managerEmail);}

    //돌봄 서비스 종료 리스트
    public List<User4CareDTO> careServiceEndList(String userEmail){return careReservationMapper.careServiceEndList(userEmail);}

    //manager3 서비스 종료 리스트
    public List<CareReservationVO> careManagerServiceEndList(String managerEmail){return careReservationMapper.careManagerServiceEndList(managerEmail);}

    public void CareReservationUpdate(Long careReservationNum, String managerEmail){
        careReservationMapper.CareReservationUpdate(careReservationNum, managerEmail);
    }


}


