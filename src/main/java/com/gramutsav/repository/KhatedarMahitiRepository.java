package com.gramutsav.repository;

import com.gramutsav.entity.KhatedarMahiti;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KhatedarMahitiRepository extends JpaRepository<KhatedarMahiti,Long> {

    List<KhatedarMahiti>  findByMobileNo(String mobileNo);

    List<KhatedarMahiti> findAllByOrderByKhateKramankAsc();

}