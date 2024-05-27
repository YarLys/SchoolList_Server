package com.school_list.repository;

import com.school_list.models.Teacher;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    // Переопределение методов при необходимости
}

/*@Transactional
    @Modifying
    @Query(value = "INSERT INTO teachers (first_name, surname, last_name, phone, email, password) VALUES (:first_name, :surname, :last_name, :phone, :email, :password);", nativeQuery = true)
    int registerNewUser(@Param("first_name") String first_name,
                        @Param("surname") String surname,
                        @Param("last_name") String last_name,
                        @Param("phone") String phone,
                        @Param("email") String email,
                        @Param("password") String password);*/
