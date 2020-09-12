package com.mentormate.devcamp.application.business.service;

import com.mentormate.devcamp.application.persistence.entity.Bill;
import com.mentormate.devcamp.application.persistence.entity.User;
import com.mentormate.devcamp.application.persistence.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The Bill service.
 */
@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository billRepository;

    /**
     * Gets all bills.
     *
     * @return the all bills
     */
    public List<Bill> getAllBills() {
        return this.billRepository.findAll();
    }

    /**
     * Creates bill.
     *
     * @param bill the bill
     * @return the bill
     */
    public Bill createBill(Bill bill) {
        return this.billRepository.save(bill);
    }

    /**
     * Edit bill.
     *
     * @param billId the bill id
     * @param bill   the new bill
     * @return the bill
     */
    public Bill editBill(long billId, Bill bill) {
        Bill editBill = this.billRepository.getOne(billId);

        editBill.setUser(bill.getUser());
        editBill.setPrice(bill.getPrice());
        editBill.setDate(bill.getDate());

        return editBill;
    }

    /**
     * User has bill.
     *
     * @param user the user
     * @return true if the user has bill and false if he doesn't
     */
    public boolean userHasBill(User user) {
        return this.billRepository.findOneByUserId(user.getId())!=null;
    }

    /**
     * Gets bill by user id.
     *
     * @param id the id
     * @return the bill by user id
     */
    public Bill getBillByUserId(long id) {
        return this.billRepository.findOneByUserId(id);
    }

    /**
     * Delete bill by id.
     *
     * @param billId the bill id
     * @return the bill
     */
    public Bill deleteBillById(long billId) {
        Bill deleteBill = this.billRepository.getOne(billId);

        this.billRepository.delete(deleteBill);

        return deleteBill;
    }
}

