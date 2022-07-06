package com.project.dolbomi.service.user;

import com.project.dolbomi.domain.dao.AccReservationDAO;
import com.project.dolbomi.domain.dao.CareReservationDAO;
import com.project.dolbomi.domain.dao.ReviewDAO;
import com.project.dolbomi.domain.dao.UserDAO;
import com.project.dolbomi.domain.vo.*;
import lombok.RequiredArgsConstructor;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.apache.commons.mail.HtmlEmail;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
@Qualifier("user")
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    private final ReviewDAO reviewDAO;
    private final AccReservationDAO accReservationDAO;
    private final CareReservationDAO careReservationDAO;


    @Override
    public boolean careApprove(CareReservationVO careReservationVO) {
        return false;
    }

    @Override
    public boolean careRefuse(CareReservationVO careReservationVO) {
        return false;
    }

    @Override
    public boolean careDelte(Long careReservationNum) {
        return false;
    }

    @Override
    public boolean careManagerRefuse(CareReservationVO careReservationV) {
        return false;
    }

    @Override
    public boolean AccGetList(Long careReservationNum) {
        return false;
    }

    @Override
    public AccReservationVO accSelect(Long accReservationNum) {
        return null;
    }

    //    동행서비스 예약자 1명 정보
    @Override
    public AccReservationVO AccGet(Long accReservationNum) {
        return accReservationDAO.AccGet(accReservationNum);
    }

    @Override
    public int accgetTotal1(String userEmail) {
        return accReservationDAO.accgetTotal1(userEmail);
    }
    @Override
    public int accgetTotal2(String userEmail) {
        return accReservationDAO.accgetTotal2(userEmail);
    }
    @Override
    public int accgetTotal3(String userEmail) {
        return accReservationDAO.accgetTotal3(userEmail);
    }
    @Override
    public int accgetTotal4(String userEmail) {
        return accReservationDAO.accgetTotal4(userEmail);
    }

    @Override
    public AccReservationVO accgetNum1(String userEmail) {
        return accReservationDAO.accgetNum1(userEmail);
    }

    @Override
    public User4AccDTO accManagerJoin(String userEmail) {
        return accReservationDAO.accManagerJoin(userEmail);
    }

    @Override
    public User4AccDTO accgetNum2(String userEmail) {
        return accReservationDAO.accgetNum2(userEmail);
    }

    @Override
    public User4AccDTO accgetNum3(String userEmail) {
        return accReservationDAO.accgetNum3(userEmail);
    }

    @Override
    public AccReservationVO accgetNum4(String userEmail) {
        return accReservationDAO.accgetNum4(userEmail);
    }


    // 동행서비스 매니저 배정 수락 user_userdetails페이지
    @Override
    public void AccManagerY(Long accReservationNum) {
        accReservationDAO.AccManagerY(accReservationNum);
    }
    // 동행서비스 매니저 배정 거절 user_userdetails페이지
    @Override
    public void AccManagerN(Long accReservationNum) {
        accReservationDAO.AccManagerN(accReservationNum);
    }
    // 동행서비스고객이 예약취소,user_userdetails2 페이지의 동행예약 취소
    @Override
    public void Accdelete(Long accReservationNum) {
        accReservationDAO.Accdelete(accReservationNum);
    }

    @Override
    public AccReservationVO accManagerView(String managerEmail) {
        return accReservationDAO.accManagerView(managerEmail);
    }

    @Override
    public AccReservationVO accManagerView2(String managerEmail) {
        return accReservationDAO.accManagerView2(managerEmail);
    }

    //동행서비스 매니저의 업무 시작,manager 페이지의 동행예약목록
    @Override
    public void AccManagerStart(Long accReservationNum) {
        accReservationDAO.AccManagerStart(accReservationNum);
    }
    //동행서비스 매니저의 업무 종료,manager 페이지의 동행예약목록
    @Override
    public void AccManagerEnd(Long accReservationNum) {
        accReservationDAO.AccManagerEnd(accReservationNum);
    }
    //동행서비스 매니저가 업무 취소,manager 페이지의 동행예약목록
    @Override
    public void AccManagerCancel(Long accReservationNum) {
        accReservationDAO.AccManagerCancel(accReservationNum);
    }

    @Override
    public ManagerVO accgetManagerInfo(String userEmail) {
      return accReservationDAO.accgetManagerInfo(userEmail);
    }

    @Override
    public ManagerVO caregetManagerInfo(String userEmail) {
        return careReservationDAO.caregetManagerInfo(userEmail);
    }
    //    돌봄서비스 예약자 1명 정보
    @Override
    public CareReservationVO CareGet(Long careReservationNum) {
        return careReservationDAO.CareGet(careReservationNum);
    }

    @Override
    public CareReservationVO caregetNum1(String userEmail) {
        return careReservationDAO.caregetNum1(userEmail);
    }

    @Override
    public User4CareDTO careManagerJoin(String userEmail) {
        return careReservationDAO.careManagerJoin(userEmail);
    }

    @Override
    public User4CareDTO caregetNum2(String userEmail) {
        return careReservationDAO.caregetNum2(userEmail);
    }

    @Override
    public User4CareDTO caregetNum3(String userEmail) {
        return careReservationDAO.caregetNum3(userEmail);
    }

    @Override
    public CareReservationVO caregetNum4(String userEmail) {
        return careReservationDAO.caregetNum4(userEmail);
    }

    @Override
    public int caregetTotal5(String userEmail) {
        return careReservationDAO.caregetTotal5(userEmail);
    }
    @Override
    public int caregetTotal6(String userEmail) {
        return careReservationDAO.caregetTotal6(userEmail);
    }
    @Override
    public int caregetTotal7(String userEmail) {
        return careReservationDAO.caregetTotal7(userEmail);
    }
    @Override
    public int caregetTotal8(String userEmail) {
        return careReservationDAO.caregetTotal8(userEmail);
    }
    // 돌봄서비스 매니저 배정 수락 user_userdetails페이지
    @Override
    public void CareManagerY(Long careReservationNum) {
        careReservationDAO.CareManagerY(careReservationNum);
    }
    // 돌봄서비스 매니저 배정 거절 user_userdetails페이지
    @Override
    public void CareManagerN(Long careReservationNum) {
        careReservationDAO.CareManagerN(careReservationNum);
    }
    // 돌봄서비스고객이 예약취소,user_userdetails2 페이지의 돌봄예약 취소
    @Override
    public void Caredelete(Long careReservationNum) {
        careReservationDAO.Caredelete(careReservationNum);
    }

    @Override
    public CareReservationVO careManagerView(String managerEmail) {
        return careReservationDAO.careManagerView(managerEmail);
    }

    @Override
    public CareReservationVO careManagerView2(String managerEmail) {
        return careReservationDAO.careManagerView2(managerEmail);
    }

    //동행서비스 매니저의 업무 시작,manager 페이지의 동행예약목록
    @Override
    public void CareManagerStart(Long careReservationNum) {
        careReservationDAO.CareManagerStart(careReservationNum);
    }
    //동행서비스 매니저의 업무 종료,manager 페이지의 동행예약목록
    @Override
    public void CareManagerEnd(Long careReservationNum) {
        careReservationDAO.CareManagerEnd(careReservationNum);
    }
    //동행서비스 매니저가 업무 취소,manager 페이지의 동행예약목록
    @Override
    public void CareManagerCancel(Long careReservationNum) {
        careReservationDAO.CareManagerCancel(careReservationNum);
    }


    @Override
    public List<AccReservationVO> AccResult(String accReservationName) {
        return null;
    }


    @Override
    public void join(UserVO userVO) {
        userDAO.join(userVO);
    }

    @Override
    public void withdrawal(String userEmail) {
        userDAO.withdrawal(userEmail);
    }


    @Override
    public boolean userLogIn(String userEmail, String userPw) {
        return userDAO.userLogIn(userEmail, userPw);
    }

    @Override
    public int emailCheck(String userEmail) {
        int cnt = userDAO.emailCheck(userEmail);
        return cnt;
    }

    @Override
    public String findId(String userName, String userPhoneNum, String userBrith) {

        String result ="";

        try {
            result= userDAO.findId(userName, userPhoneNum, userBrith);

        } catch(Exception e) {

            e.printStackTrace();
        }

        return result ;
    }

    //  비밀번호 찾기 이메일 발송
    @Override
    public void sendEmail(UserVO userVO, String div) throws Exception {
        // Mail Server 설정
        String charSet = "utf-8";
        String hostSMTP = "smtp.gmail.com"; //네이버 이용시 smtp.naver.com
        String hostSMTPid = "spring.dolbomi@gmail.com";
        String hostSMTPpwd = "google#2022";

        // 보내는 사람 EMail, 제목, 내용
        String fromEmail = "spring.dolbomi@gmail.com";
        String fromName = "dolbomi";
        String subject = "";
        String msg = "";

        if(div.equals("findpw")) {
            subject = "돌보미 임시 비밀번호 입니다.";
            msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
            msg += "<h3 style='color: blue;'>";
            msg += userVO.getUserName() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.</h3>";
            msg += "<p>임시 비밀번호 : ";
            msg += userVO.getUserPw() + "</p></div>";
        }

        // 받는 사람 E-Mail 주소
        String mail = userVO.getUserEmail();
        try {
            HtmlEmail email = new HtmlEmail();
            email.setDebug(true);
            email.setCharset(charSet);
            email.setSSL(true);
            email.setHostName(hostSMTP);
            email.setSmtpPort(465); //네이버 이용시 587

            email.setAuthentication(hostSMTPid, hostSMTPpwd);
            email.setTLS(true);
            email.addTo(mail, charSet);
            email.setFrom(fromEmail, fromName, charSet);
            email.setSubject(subject);
            email.setHtmlMsg(msg);
            email.send();
        } catch (Exception e) {
            System.out.println("메일발송 실패 : " + e);
        }
    }

//    비밀번호 찾기
    @Override
    public void findPw(HttpServletResponse resp, UserVO userVO) throws Exception {
        resp.setContentType("text/html;charset=utf-8");
        UserVO ck = userDAO.selectProfile(userVO.getUserEmail());
        PrintWriter out = resp.getWriter();

        // 가입된 이메일이 아니면
        if(!userVO.getUserEmail().equals(ck.getUserEmail())) {
            out.print("등록되지 않은 이메일입니다.");
            out.close();
        }else {
            // 임시 비밀번호 생성
            String pw = "";
            for (int i = 0; i < 12; i++) {
                pw += (char) ((Math.random() * 26) + 97);
            }
            userVO.setUserPw(pw);
            // 비밀번호 변경
//            userDAO.updatePw(userVO);
            // 비밀번호 변경 메일 발송
            sendEmail(userVO, "findPw");

            out.print("이메일로 임시 비밀번호를 발송하였습니다.");
            out.close();
        }

    }


    @Override
    public void phoneCerti(String userPhoneNum, int randomNum) {
        String api_key = "NCSXDCGPLMOHCTXM";
        String api_secret = "QE2G9LQD0VVEUY44E4XSCQH4ABZGOIQC";
        Message coolsms = new Message(api_key, api_secret);

        // 4 params(to, from, type, text) are mandatory. must be filled
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", userPhoneNum);    // 수신전화번호
        params.put("from", "010-8526-7235");    // 발신전화번호. 테스트시에는 발신,수신 둘다 본인 번호로 하면 됨
        params.put("type", "SMS");
        params.put("text", "[TEST] 인증번호는" + "["+randomNum+"]" + "입니다."); // 문자 내용 입력
        params.put("app_version", "test app 2.2"); // application name and version

        try {
            JSONObject obj = (JSONObject) coolsms.send(params);
            System.out.println(obj.toString());
        } catch (CoolsmsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
        }


    }

    @Override
    public UserVO profile(String userEmail) {
        return userDAO.selectProfile(userEmail);
    }

    @Override
    public void modify(UserVO userVO) {

    }

    @Override
    public List<UserVO> getList(Criteria criteria) {
        return null;
    }


    @Override
    public int getTotal() {
        return userDAO.getTotal();
    }

    /*ReviewDAO*/
    @Override
    public List<ReviewVO> reviewGetList(Criteria criteria) {return reviewDAO.reviewGetList(criteria);}

    @Override
    public void register(ReviewVO reviewVO) {reviewDAO.register(reviewVO);}

    @Override
    public ReviewVO get(Long reviewNum) {
        return reviewDAO.findByReviewNum(reviewNum);
    }

    //@Override
    //public ReviewVO findByReviewNum(Long reviewNum) {
    //    return reviewDAO.findByReviewNum(reviewNum);
    //}

    @Override
    public boolean modify(ReviewVO reviewVO) {
        return reviewDAO.modify(reviewVO);
    }

    @Override
    public boolean reviewRemove(Long reviewNum) {
        return reviewDAO.reviewRemove(reviewNum);
    }

    @Override
    public int reviewGetTotal(Criteria criteria) {
        return reviewDAO.reviewGetTotal(criteria);
    }

    @Override
    public int myReviewGetTotal(Criteria criteria, String userEmail) {
        return reviewDAO.myReviewGetTotal(criteria, userEmail);
    }

    @Override
    public List<UserReviewDTO> reviewGetListUser(Criteria criteria, String userEmail) {
        return reviewDAO.reviewGetListUser(criteria, userEmail);
    }


    // acc reservation review list
    @Override
    public List<AccReviewDTO> reviewGetListAcc(String userEmail){
        return accReservationDAO.reviewGetListAcc(userEmail);
    }

    // care reservation review list
    @Override
    public List<CareReviewDTO> reviewGetListCare(String userEmail){
        return careReservationDAO.reviewGetListCare(userEmail);
    }

    //care reservation select one
    @Override
    public CareReservationVO selectCare(Long careReservationNum) {
        return careReservationDAO.selectCare(careReservationNum);
    }



    // acc reservation select one
    @Override
    public AccReservationVO selectAcc(Long accReservationNum) {
        return accReservationDAO.selectAcc(accReservationNum);
    }

    @Override
    public List<AccReservationVO> getListAccReservation(Criteria criteria, List<String> areaAr) {return accReservationDAO.getListAccReservation(criteria, areaAr);}

    @Override
    public List<CareReservationVO> getListCareReservation(Criteria criteria, List<String> areaAr) {return careReservationDAO.getListCareReservation(criteria, areaAr);}


    @Override
    public void AccReservationUpdate(Long accReservationNum, String managerEmail) {
        accReservationDAO.AccReservationUpdate(accReservationNum, managerEmail);
    }

    @Override
    public void CareReservationUpdate(Long careReservationNum, String managerEmail) {
        careReservationDAO.CareReservationUpdate(careReservationNum, managerEmail);
    }

    @Override
    public List<User4CareDTO> careServiceEndList(String userEmail) {
        return careReservationDAO.careServiceEndList(userEmail);
    }

    @Override
    public List<User4AccDTO> accServiceEndList(String userEmail) {
        return accReservationDAO.accServiceEndList(userEmail);
    }

    @Override
    public List<CareReservationVO> careManagerServiceEndList(String managerEmail) {
        return careReservationDAO.careManagerServiceEndList(managerEmail);
    }

    @Override
    public List<AccReservationVO> accManagerServiceEndList(String managerEmail) {
        return accReservationDAO.accManagerServiceEndList(managerEmail);
    }

}