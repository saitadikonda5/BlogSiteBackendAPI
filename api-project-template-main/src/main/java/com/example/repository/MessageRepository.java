package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
// import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

import com.example.entity.Account;
import com.example.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{

}
