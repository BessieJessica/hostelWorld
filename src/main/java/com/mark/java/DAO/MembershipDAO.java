package com.mark.java.DAO;

import com.mark.java.entity.Membership;

/**
 * Created by lois on 2017/3/12.
 */
public interface MembershipDAO {

    public Membership create(String identity);

    public Membership findByMemberId(int memberId);

    public Membership findByIdentity(String identity);

    public Membership update(Membership membership);
}
