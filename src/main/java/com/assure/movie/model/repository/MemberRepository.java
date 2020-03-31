package com.assure.movie.model.repository;

import com.assure.movie.model.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Israel Yasis
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
