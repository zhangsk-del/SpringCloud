package com.zsk.payment.dao;

import com.zsk.api.domain.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDao {
    @Insert("insert into payment values(#{id},#{serial})")
    int add(Payment payment);

    @Select("select id,serial from payment where id=#{id}")
    Payment findById(Long id);
}
