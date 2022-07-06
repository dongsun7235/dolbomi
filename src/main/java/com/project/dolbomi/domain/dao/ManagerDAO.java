package com.project.dolbomi.domain.dao;

import com.project.dolbomi.domain.vo.ManagerVO;
import com.project.dolbomi.domain.vo.UserVO;
import com.project.dolbomi.mapper.ManagerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ManagerDAO {
    private final ManagerMapper managerMapper;

    //    동행서비스 리스트
    public void accGetList(){

    }
    //    돌봄서비스 리스트
    public void careGetList(){

    }

    //    동행서비스 신청
    public void accApply(long accReservationNum){

    }
    //    돌봄서비스 신청
    public void careApply(long careReservationNum){

    }

    // 매니저 회원가입
    public void join(ManagerVO managerVO){
        managerMapper.insert(managerVO);
    }

    // 매니저 로그인
    public boolean managerLogIn(String managerEmail, String managerPw){return managerMapper.managerLogIn(managerEmail, managerPw) == 1;}

    //이메일 중복체크
    public int emailCheck(String managerEmail){
        int cnt = managerMapper.emailCheck(managerEmail);
        return cnt;
    }

    //아이디 찾기
    public ManagerVO findId(String managerName, String managerPhoneNum, String managerBirth) {
        return managerMapper.findId(managerName, managerPhoneNum, managerBirth);
    }
    //비밀번호 찾기
    public ManagerVO findPw(String managerName, String managerPhoneNum, String managerBirth, String managerEmail) {
        return managerMapper.findPw(managerName, managerPhoneNum, managerBirth, managerEmail);
    }

    //    매니저 탈퇴
    public void withdrawal(String userEmail){
        managerMapper.delete(userEmail);
    }

    /*//프로필 수정
    public boolean managermodify(ManagerVO managerVO){

        return managerMapper.updateProfile(managerVO) == 1;
    }*/
    public int getTotal(){
        return managerMapper.getTotal();
    }

    /*매니저 정보*/
    public ManagerVO managerInfo(String managerEmail) {return managerMapper.managerInfo(managerEmail);}
    public ManagerVO managerInfoacc(String userEmail) {return managerMapper.managerInfoacc(userEmail);}
    public ManagerVO managerInfocare(String userEmail) {return managerMapper.managerInfocare(userEmail);}

    //프로필 수정
    public void managermodify(ManagerVO managerVO){
        managerMapper.updateProfile(managerVO);
    }
}

