package com.project.dolbomi.mapper;



import com.project.dolbomi.domain.vo.ManagerVO;
import com.project.dolbomi.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ManagerMapper {

    //    동행서비스 리스트
    public List<ManagerVO> accgetList();
    //    돌봄서비스 리스트
    public List<ManagerVO> caregetList();

    //    동행서비스 신청
    public int accapply(long accReservationNum);
    //    돌봄서비스 신청
    public int careapply(long careReservationNum);

    //    매니저 탈퇴
    public void delete(String userEmail);


    public int getTotal();

    //매니저 회원가입
    public void insert(ManagerVO managerVO);

    //이메일 중복체크
    public int emailCheck(String managerEmail);

    //매니저 로그인
    public int managerLogIn(String managerEmail, String managerPw);

    //아이디 찾기
    public ManagerVO findId(String managerName, String managerPhoneNum, String managerBirth);

    //비밀번호 찾기
    public ManagerVO findPw(String managerName, String managerPhoneNum, String managerBirth, String managerEmail);

    public ManagerVO managerInfo(String managerEmail);
    public ManagerVO managerInfoacc(String userEmail);
    public ManagerVO managerInfocare(String userEmail);

    public void updateProfile(ManagerVO managerVO);
}
