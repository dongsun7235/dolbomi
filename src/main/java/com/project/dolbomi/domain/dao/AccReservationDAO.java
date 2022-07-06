package com.project.dolbomi.domain.dao;

import com.project.dolbomi.domain.vo.*;
import com.project.dolbomi.mapper.AccReservationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AccReservationDAO {
    private final AccReservationMapper accReservationMapper;

    public List<AccReservationVO> AccResult(String accReservationName){
        return accReservationMapper.AccResult(accReservationName);
    }

    //    동행서비스 예약하기
    public void accReservation(AccReservationVO accReservationVO){
        accReservationMapper.insert(accReservationVO);
    }
    //    동행서비스 예약정보확인
    public void accReservationInfo(Long accReservationNum){

    }

    // accreservation review list
    public List<AccReviewDTO> reviewGetListAcc(String userEmail) {
        return accReservationMapper.reviewGetListAcc(userEmail);
    }

    //    동행서비스 리스트
    public List<AccReservationVO> getListAccReservation(Criteria criteria, List<String> areaAr) {
        return accReservationMapper.getListAccReservation(criteria, areaAr);
    }



    // 동행서비스 매니저 배정 수락 user_userdetails페이지
    public void AccManagerY(Long accReservationNum){
        accReservationMapper.AccManagerY(accReservationNum) ;
    }
    // 동행서비스 매니저 배정 거절 user_userdetails페이지
    public void AccManagerN(Long accReservationNum){
        accReservationMapper.AccManagerN(accReservationNum);
    }

    // 동행서비스고객이 예약취소,user_userdetails2 페이지의 동행예약 취소
    public void Accdelete(Long accReservationNum){
        accReservationMapper.Accdelete(accReservationNum);
    }
    //동행서비스 매니저의 업무 시작,manager 페이지의 동행예약목록
    public void AccManagerStart(Long accReservationNum){
        accReservationMapper.AccManagerStart(accReservationNum) ;
    }
    //동행서비스 매니저의 업무 종료,manager 페이지의 동행예약목록
    public void AccManagerEnd(Long accReservationNum){
        accReservationMapper.AccManagerEnd(accReservationNum);
    }

    //동행서비스 매니저가 업무 취소,manager 페이지의 동행예약목록
    public void AccManagerCancel(Long accReservationNum){
        accReservationMapper.AccManagerCancel(accReservationNum);
    }

    //    동행서비스 예약자 1명 정보
    public AccReservationVO AccGet(Long accReservationNum){
        return accReservationMapper.AccGet(accReservationNum)  ;
    }

    public AccReservationVO accgetNum1(String userEmail){ return accReservationMapper.accgetNum1(userEmail);}
    public User4AccDTO accManagerJoin(String userEmail){return accReservationMapper.accManagerJoin(userEmail);}
    public User4AccDTO accgetNum2(String userEmail){ return accReservationMapper.accgetNum2(userEmail);}
    public User4AccDTO accgetNum3(String userEmail){ return accReservationMapper.accgetNum3(userEmail);}
    public AccReservationVO accgetNum4(String userEmail){ return accReservationMapper.accgetNum4(userEmail);}

    public int accgetTotal1(String userEmail){
        return accReservationMapper.accgetTotal1(userEmail);
    }
    public int accgetTotal2(String userEmail){
        return accReservationMapper.accgetTotal2(userEmail);
    }
    public int accgetTotal3(String userEmail){
        return accReservationMapper.accgetTotal3(userEmail);
    }
    public int accgetTotal4(String userEmail) {
        return accReservationMapper.accgetTotal4(userEmail);
    }

    public int accgetManagerTotal2(String managerEmail){
        return accReservationMapper.accgetManagerTotal2(managerEmail);
    }
    public int accgetManagerTotal3(String managerEmail){
        return accReservationMapper.accgetManagerTotal3(managerEmail);
    }
    public int accgetManagerTotal4(String managerEmail) {
        return accReservationMapper.accgetManagerTotal4(managerEmail);
    }
    // accreservation select one
    public AccReservationVO selectAcc(Long accReservationNum){
        return accReservationMapper.selectAcc(accReservationNum);
    }

        public int accgetTotal1(Long accReservationNum){
            return accReservationMapper.accgetTotal1(accReservationNum);
        }
        public int accgetTotal2(Long accReservationNum){
            return accReservationMapper.accgetTotal2(accReservationNum);
        }
        public int accgetTotal3(Long accReservationNum){
            return accReservationMapper.accgetTotal3(accReservationNum);
        }
        public int accgetTotal4(Long accReservationNum){
            return accReservationMapper.accgetTotal4(accReservationNum);
        }

        public void AccReservationUpdate(Long accReservationNum, String managerEmail) {
            accReservationMapper.AccReservationUpdate(accReservationNum, managerEmail);
        }

        //동행 서비스 매니저 연결,status 0
        public AccReservationVO accManagerView(String managerEmail){return accReservationMapper.accManagerView(managerEmail);}

        //동행 서비스 매니저 연결,status 6
        public AccReservationVO accManagerView2(String managerEmail){return accReservationMapper.accManagerView2(managerEmail);}

        //동행 서비스 종료 리스트
        public List<User4AccDTO> accServiceEndList(String userEmail){return accReservationMapper.accServiceEndList(userEmail);}

    //manager3 서비스 종료 리스트
    public List<AccReservationVO> accManagerServiceEndList(String managerEmail){return accReservationMapper.accManagerServiceEndList(managerEmail);}

    //유저 이메일로 매니저 예약메일 통해 매니저정보얻기
    public ManagerVO accgetManagerInfo(String userEmail){return accReservationMapper.accgetManagerInfo(userEmail);}


}

