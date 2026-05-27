package com.gramutsav.repository;

import com.gramutsav.entity.ShareHolder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShareHolderRepository extends JpaRepository<ShareHolder,Long> {
    List<ShareHolder> findByMobilenumber(String mobilenumber);

}
