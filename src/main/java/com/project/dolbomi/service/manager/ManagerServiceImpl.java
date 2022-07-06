package com.project.dolbomi.service.manager;

import com.project.dolbomi.domain.dao.ManagerDAO;
import com.project.dolbomi.domain.vo.Criteria;
import com.project.dolbomi.domain.vo.ManagerVO;
import com.project.dolbomi.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private final ManagerDAO managerDAO;

    @Override
    public void accGetList() {

    }

    @Override
    public void careGetList() {

    }

    @Override
    public void accApply(long accReservationNum) {

    }

    @Override
    public void careApply(long careReservationNum) {

    }

     @Override
    public void withdrawal(String userEmail) {
        managerDAO.withdrawal(userEmail);
    }

    @Override
    public List<ManagerVO> getList(Criteria criteria) {
        return null;
    }

    @Override
    public int getTotal() {
        return managerDAO.getTotal();
    }

    @Override
    public ManagerVO getManagerPro(String userEmail) {
        return null;
    }

    @Override
    public void join(ManagerVO managerVO) {
        managerDAO.join(managerVO);
    }

    @Override
    public int emailCheck(String managerEmail) {
        int cnt = managerDAO.emailCheck(managerEmail);
        return cnt;
    }

    @Override
    public ManagerVO findId(String managerName, String managerPhoneNum, String managerBirth) {
        return managerDAO.findId(managerName, managerPhoneNum, managerBirth);
    }

    @Override
    public ManagerVO findPw(String managerName, String managerPhoneNum, String managerBirth, String managerEmail) {
        return managerDAO.findPw(managerName, managerPhoneNum, managerBirth, managerEmail);
    }

    @Override
    public boolean managerLogIn(String managerEmail, String managerPw) {
        return managerDAO.managerLogIn(managerEmail, managerPw);
    }

    @Override
    public ManagerVO managerInfo(String managerEmail) {
        return managerDAO.managerInfo(managerEmail);
    }


    @Override
    public ManagerVO managerInfoacc(String userEmail) {
        return managerDAO.managerInfoacc(userEmail);
    }


    @Override
    public ManagerVO managerInfocare(String userEmail) {
        return managerDAO.managerInfocare(userEmail);
    }
    
     @Override
    public void modify(ManagerVO managerVO) {
        managerDAO.managermodify(managerVO);
    }
}
