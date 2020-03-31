package com.assure.movie.model.repository;

import com.assure.movie.model.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Israel Yasis
 */
@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
}
