package com.project.dolbomi.controller.user;
import com.project.dolbomi.domain.vo.*;
import com.project.dolbomi.mapper.AccReservationMapper;
import com.project.dolbomi.service.manager.ManagerService;
import com.project.dolbomi.service.member.MemberService;

import com.project.dolbomi.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user/*")
public class UserController {
    private final MemberService memberService;
    private final UserService userService;
    private final ManagerService managerService;


    //    회원가입1
    @PostMapping("regi1")
    public String join1(UserVO userVO, Model model){
        log.info("---------------------------------------");
        log.info("join1............. : " + userVO);
        log.info("---------------------------------------");

        model.addAttribute("userVO", userVO);
        return "/user/regi2";
    }

    //    이메일 중복검사
    @PostMapping("emailcheck")
    @ResponseBody
    public int emailCheck(@RequestParam("userEmail") String userEmail){
        int cnt = userService.emailCheck(userEmail);
        return cnt;
    }

    //    회원가입2
    @PostMapping("regi2")
    public String join2(UserVO userVO){
        log.info("---------------------------------------");
        log.info("join2............. : " + userVO);
        log.info("---------------------------------------");

        userService.join(userVO);
        return "/member/userlogin";
    }

//    휴대폰 인증번호 발송
    @GetMapping("/phoneCheck")
    @ResponseBody
    public String sendSMS(@RequestParam("phone") String userPhoneNum){
        int randomNum = (int)((Math.random() * (9999 - 1000 + 1)) + 1000);
        userService.phoneCerti(userPhoneNum, randomNum);

        return Integer.toString(randomNum);

    }

    @PostMapping("sendcode")
    public String phoneCerti(){
        return "/user/sendcode";
    }

//    동행 서비스 예약
//    @GetMapping("reservAcc")
//    public void accReservation(){
//
//    }

    //    동행 서비스 예약 1단계
    @PostMapping("acc_reservation2")
    public void acc_reserv1(AccReservationVO accReservationVO, Model model){

        log.info("accReservationVO..........." + accReservationVO);

        model.addAttribute("accReservationVO", accReservationVO);
    }

    //    동행 서비스 예약 2단계
    @PostMapping("acc_reservation3")
    public void acc_reserv2(AccReservationVO accReservationVO, Model model){
        log.info("accReservationVO..........." + accReservationVO);

        model.addAttribute("accReservationVO", accReservationVO);
    }

    //    동행 서비스 예약 완료단계
    @PostMapping("reservAcc")
    public RedirectView accReservation(AccReservationVO accReservationVO){
        log.info("accReservationVO..........." + accReservationVO);
        memberService.accReservation(accReservationVO);

        return new RedirectView("/user/acc_confirmation");
    }

//    돌봄 서비스 예약
//    @GetMapping("reservCare")
//    public void careReservation(){
//
//    }

    //    돌봄 서비스 예약 1단계
    @PostMapping("care_reservation2")
    public void care_reserv1(CareReservationVO careReservationVO, Model model){

        log.info("careReservationVO..........." + careReservationVO);

        model.addAttribute("careReservationVO", careReservationVO);
    }

    //    돌봄 서비스 예약 2단계
    @PostMapping("care_reservation3")
    public void care_reserv2(CareReservationVO careReservationVO, Model model){
        log.info("careReservationVO..........." + careReservationVO);

        model.addAttribute("careReservationVO", careReservationVO);
    }

    //    돌봄 서비스 예약 완료단계
    @PostMapping("reservCare")
    public RedirectView careReservation(CareReservationVO careReservationVO) {
        log.info("careReservationVO..........." + careReservationVO);
        memberService.careReservation(careReservationVO);

        return new RedirectView("/user/care_confirmation");
    }

//    동행 서비스 결제
//    @GetMapping("payAcc")
//    public void accPayment(){
//
//    }

/*
    @PostMapping("payAcc")
    public String accPayment(){
        return "/user/user_userdetails";
    }
*/

//    돌봄 서비스 결제
//    @GetMapping("payCare")
//    public void carePayment(){
//
//    }


    @PostMapping("payCare")
    public String carePayment(){
        return "/user/user_usedetails";
    }



    //    서비스 상태 변경(배정취소)
    @GetMapping("matchingCancel")
    public void allocationCancel(){

    }

    //    서비스 상태 변경(배정수락)
    @GetMapping("matchingAccept")
    public String allocationAccept(){
        return "/user/user_details2";
    }


    //    페이지 이동
    @GetMapping("acc_reservation1")
    public void acc_reservation1(){}

    @GetMapping("acc_reservation2")
    public void acc_reservation2(){}

    @GetMapping("acc_reservation3")
    public void acc_reservation3(){}

    @GetMapping("acc_confirmation")
    public void acc_confirmation(){}

    @GetMapping("care_reservation1")
    public void care_reservation1(){}

    @GetMapping("care_reservation2")
    public void care_reservation2(){}

    @GetMapping("care_reservation3")
    public void care_reservation3(){}

    @GetMapping("care_confirmation")
    public void care_confirmation(){}

    @GetMapping("option_reservation")
    public void option_reservation(){}

    @GetMapping("regi1")
    public void regi1(){}

    @GetMapping("regi2")
    public void regi2(){}

    @GetMapping("user_userdetails")
    public void user_userdetails(Model model, HttpServletRequest request) {

        HttpSession httpSession = request.getSession();
        String email=String.valueOf(httpSession.getAttribute("userEmail"));
        userService.accgetTotal1(email);
        log.info("-----------------------"+email);

        model.addAttribute("accreservationlist", userService.accgetNum1(email));
        model.addAttribute("totallist1", userService.accgetTotal1(email));
        model.addAttribute("totallist2", userService.accgetTotal2(email));
        model.addAttribute("totallist3", userService.accgetTotal3(email));
        model.addAttribute("totallist4", userService.accgetTotal4(email));

        model.addAttribute("carereservationlist", userService.caregetNum1(email));
        model.addAttribute("totallist5", userService.caregetTotal5(email));
        model.addAttribute("totallist6", userService.caregetTotal6(email));
        model.addAttribute("totallist7", userService.caregetTotal7(email));
        model.addAttribute("totallist8", userService.caregetTotal8(email));


        model.addAttribute("accmanagerInfo", userService.accManagerJoin(email));
        model.addAttribute("caremanagerInfo", userService.careManagerJoin(email));



    }

    /* user_userdetails 의  매니저 수락*/
    @PostMapping("matchingAccept")
    public String matchingAccept(HttpServletRequest request) {

        HttpSession httpSession = request.getSession();
        httpSession.getAttribute("userEmail");
        String email=String.valueOf(httpSession.getAttribute("userEmail"));

        String accNum = request.getParameter("accReservationNum");
        String careNum = request.getParameter("careReservationNum");

        if(accNum != null){
            userService.AccManagerY(Long.parseLong(accNum));
            return "user/user_userdetails2";
        }

        userService.CareManagerY(Long.parseLong(careNum));
        return "user/user_userdetails2";
    }

    /* user_userdetails 의  매니저 거절*/
    @PostMapping("matchingCancel")
    public String matchingCancel(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        httpSession.getAttribute("userEmail");
        String email=String.valueOf(httpSession.getAttribute("userEmail"));

        String accNum = request.getParameter("accReservationNum");
        String careNum = request.getParameter("careReservationNum");

        if(accNum != null){
            userService.AccManagerN(Long.parseLong(accNum));
            return "user/user_userdetails";
        }

        userService.CareManagerN(Long.parseLong(careNum));
        return "user/user_userdetails";
    }

    @GetMapping("user_userdetails2")
    public void user_userdetails2(Model model,HttpServletRequest request) {

        HttpSession httpSession = request.getSession();
        httpSession.getAttribute("userEmail");
        String email=String.valueOf(httpSession.getAttribute("userEmail"));

        model.addAttribute("accreservationlist", userService.accgetNum2(email));
        model.addAttribute("totallist1", userService.accgetTotal1(email));
        model.addAttribute("totallist2", userService.accgetTotal2(email));
        model.addAttribute("totallist3", userService.accgetTotal3(email));
        model.addAttribute("totallist4", userService.accgetTotal4(email));

        model.addAttribute("carereservationlist", userService.caregetNum2(email));
        model.addAttribute("totallist5", userService.caregetTotal5(email));
        model.addAttribute("totallist6", userService.caregetTotal6(email));
        model.addAttribute("totallist7", userService.caregetTotal7(email));
        model.addAttribute("totallist8", userService.caregetTotal8(email));

    }

    //    서비스 상태 변경(예약취소)
    @RequestMapping(value = "user/reservCancel", method = {RequestMethod.POST})
    public String reservationCancel(HttpServletRequest request){

        String accNum = request.getParameter("accReservationNum");
        String careNum = request.getParameter("careReservationNum");
        log.info("accNum--------------" + accNum);
        log.info("careNum--------------" + careNum);
        if(accNum != null){
            userService.Accdelete(Long.parseLong(accNum));
            return "user/user_userdetails2";
        }

        userService.Caredelete(Long.parseLong(careNum));
        return "user/user_userdetails2";
    }

    @GetMapping("user_userdetails3")
    public void user_userdetails3( Model model,HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        httpSession.getAttribute("userEmail");
        String email=String.valueOf(httpSession.getAttribute("userEmail"));

        model.addAttribute("accreservationlist", userService.accgetNum3(email));
        model.addAttribute("totallist1", userService.accgetTotal1(email));
        model.addAttribute("totallist2", userService.accgetTotal2(email));
        model.addAttribute("totallist3", userService.accgetTotal3(email));
        model.addAttribute("totallist4", userService.accgetTotal4(email));

        model.addAttribute("carereservationlist", userService.caregetNum3(email));
        model.addAttribute("totallist5", userService.caregetTotal5(email));
        model.addAttribute("totallist6", userService.caregetTotal6(email));
        model.addAttribute("totallist7", userService.caregetTotal7(email));
        model.addAttribute("totallist8", userService.caregetTotal8(email));


    }

        @GetMapping("user_userdetails4")
        public String user_userdetails4(Criteria criteria, Model model, HttpServletRequest request) {
            HttpSession httpSession = request.getSession();
            String userEmail = String.valueOf(httpSession.getAttribute("userEmail"));


            Long accReservationNum = Long.valueOf(26);
            Long careReservationNum = Long.valueOf(6);

            model.addAttribute("totallist1", userService.accgetTotal1(userEmail));
            model.addAttribute("totallist2", userService.accgetTotal2(userEmail));
            model.addAttribute("totallist3", userService.accgetTotal3(userEmail));
            model.addAttribute("totallist4", userService.accgetTotal4(userEmail));

            model.addAttribute("totallist5", userService.caregetTotal5(userEmail));
            model.addAttribute("totallist6", userService.caregetTotal6(userEmail));
            model.addAttribute("totallist7", userService.caregetTotal7(userEmail));
            model.addAttribute("totallist8", userService.caregetTotal8(userEmail));

            model.addAttribute("careDTO", userService.careServiceEndList(userEmail));
            model.addAttribute("accDTO", userService.accServiceEndList(userEmail));


            model.addAttribute("pageDTO", new PageDTO(criteria, userService.getTotal()));
            return "/user/user_userdetails4";
        }

    @GetMapping("myReview")
    public String myReview(Criteria criteria, Model model, @RequestParam String userEmail, @RequestParam String userName) {
        log.info("---------------------");
        log.info("myReview--------");
        log.info("userEmail-------- " + userEmail);
        log.info("userName--------" + userName);
        log.info("criteria--------" + criteria);

        log.info("---------------------");

        model.addAttribute("UserReviewDTO", userService.reviewGetListUser(criteria, userEmail));
        model.addAttribute("pageDTO", new PageDTO(criteria, userService.myReviewGetTotal(criteria, userEmail)));

        return "/user/myReview";
    }

    @GetMapping("review")
    public String reviewGetList(Criteria criteria, Model model) {
        log.info("---------------------");
        log.info("reviewGetList--------");
        log.info("---------------------");
        log.info("criteria-----" + criteria);
        log.info("---------------------");

        model.addAttribute("reviewList", userService.reviewGetList(criteria));
        model.addAttribute("pageDTO", new PageDTO(criteria, userService.reviewGetTotal(criteria)));

        return "/user/review";
    }


    // 게시글 추가
    @PostMapping("review2")
    public RedirectView register(ReviewVO reviewVO, RedirectAttributes rttr, HttpServletRequest req) {
        log.info("----------------------------");
        log.info("register............. : " + reviewVO);
        log.info("----------------------------");

        userService.register(reviewVO);
        rttr.addFlashAttribute("reviewNum", reviewVO.getReviewNum());

        String userEmail = req.getParameter("userEmail");

        log.info("----------------------------");
        log.info("userEmail" + userEmail);
        log.info("----------------------------");
        String userName = req.getParameter("userName");
        log.info("----------------------------");
        log.info("userName" +userName);
        log.info("----------------------------");

        return new RedirectView("/user/review");
    }

    //    게시글 상세보기
    @GetMapping({"readReview", "modifyReview"})
    public String readReview(Long reviewNum, HttpServletRequest req, Model model) {
        log.info("----------------------------");
        log.info(req.getRequestURI() + "............. : " + reviewNum);
        log.info("----------------------------");
        model.addAttribute("review", userService.get(reviewNum));

        return "/user/readReview";
    }

    @GetMapping("review2")
    public String review2(HttpServletRequest req, Model model) {
        String accType = req.getParameter("accReservationType");
        String careType = req.getParameter("careReservationType");
        log.info("careType---------------" + careType);
        log.info("accType---------------" + accType);
        if(accType.isEmpty() && !careType.isEmpty()){
            log.info("careType---------------" + careType);
            model.addAttribute("careReservationType", careType);
        }else{
            log.info("accType---------------" + accType);
            model.addAttribute("accReservationType", accType);
        }
        return "/user/review2";
    }

    @GetMapping("review1")
    public String review1(Model model, @RequestParam String userEmail, @RequestParam String userName) {
        log.info("---------------------");
        log.info("review1--------");
        log.info("myReview--------");
        log.info("userEmail-------- " + userEmail);
        log.info("userName--------" + userName);
        log.info("---------------------");

        model.addAttribute("careReviewDTO", userService.reviewGetListCare(userEmail));
        model.addAttribute("accReviewDTO", userService.reviewGetListAcc(userEmail));

        /*model.addAttribute("accReviewDTO", new AccReviewDTO(userService.reviewGetListAcc()));
        model.addAttribute("careReviewDTO", new CareReviewDTO(userService.reviewGetListCare()));*/

        return "/user/review1";
    }

    // 수정
    @PostMapping("modifyReview")
    public RedirectView modifyReview(ReviewVO reviewVO, RedirectAttributes rttr) {
        log.info("----------------------------");
        log.info("modifyReview............. : " + reviewVO);
        log.info("----------------------------");
        userService.modify(reviewVO);
        rttr.addAttribute("reviewNum", reviewVO.getReviewNum());
        return new RedirectView("/user/readReview");


    }

    // 삭제
    @PostMapping("reviewRemove")
    public String reviewRemove(Long reviewNum, Criteria criteria, Model model) {
        log.info("----------------------------");
        log.info("reviewRemove............. : " + reviewNum);
        log.info("----------------------------");

        userService.reviewRemove(reviewNum);
        return reviewGetList(criteria, model);
    }

}
