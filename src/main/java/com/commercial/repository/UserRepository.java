package com.commercial.repository;

import com.commercial.entity.Bestellung;
import com.commercial.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Bestellung,Long> {


}


