package com.project.dolbomi.domain.dao;

import com.project.dolbomi.domain.vo.UserVO;
import com.project.dolbomi.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletResponse;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final UserMapper userMapper;


    /*  // 돌봄서비스 수락
      public int careApprove(long careReservationNum){
          return userMapper.careApprove(careReservationNum);
      }

      // 돌봄서비스 거절
      public int careRefuse(long careReservationNum){
          return userMapper.careRefuse(careReservationNum);
      }

      // 동행서비스 수락
      public void accApprove(long accReservationNum){

      }

      // 동행서비스 거절
      public void accRefuse(long accReservationNum){

      }
  */
    // 회원 가입
    public void join(UserVO userVO){
        userMapper.insert(userVO);
    }

    // 회원 로그인
    public boolean userLogIn(String userEmail, String userPw){
        return userMapper.userLogIn(userEmail, userPw) == 1 ;
    }

    //이메일 중복체크
    public int emailCheck(String userEmail){
        int cnt = userMapper.emailCheck(userEmail);
        return cnt;
    }

    //아이디 찾기
    public String findId(String userName, String userPhoneNum, String userBirth) {
        return userMapper.findId(userName, userPhoneNum, userBirth);
    }
    //비밀번호 찾기
//    public void findPw(HttpServletResponse resp, UserVO userVO) {
//        return userMapper.findPw(userVO, resp);
//    }

    //비밀번호 변경



    //회원 탈퇴
    public void withdrawal(String userEmail){
        userMapper.delete(userEmail) ;
    }
    //프로필 페이지
    public UserVO selectProfile(String userEmail){
        return userMapper.selectProfile(userEmail);
    }

    //프로필 수정
    public boolean usermodify(UserVO userVO){

        return userMapper.updateProfile(userVO).equals(1);
    }

    public int getTotal(){
        return userMapper.getTotal();
    }
}


