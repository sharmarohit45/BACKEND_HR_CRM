package com.youtube.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.ProposalProduct;

@Repository
public interface ProposalProductRepository extends JpaRepository <ProposalProduct,Long> {

}
