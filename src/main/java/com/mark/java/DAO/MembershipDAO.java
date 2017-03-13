package com.mark.java.DAO;

import com.mark.java.entity.Membership;

/**
 * Created by lois on 2017/3/12.
 */
public interface MembershipDAO {

    public Membership create(String cellphone, String password);

    public Membership findById(int id);

    public Membership findByMemberCode(int memberCode);

    public Membership findByCellphone(String cellphone);

    public Membership update(Membership membership);

    public boolean ifMemberExists(String cellphone);
}
