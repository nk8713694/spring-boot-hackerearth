package com.verifone.springbootverifone.repository;



import com.verifone.springbootverifone.model.Sim_card_no;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public interface Sim_card_noRepository extends JpaRepository<Sim_card_no, Long>{

    @Modifying
    @Query(value=" select * from sim_card_no s where s.expiry_date<=:date",nativeQuery = true)
    List<Sim_card_no> findByExpiry_DateLessThanEqual(Timestamp date);

}
