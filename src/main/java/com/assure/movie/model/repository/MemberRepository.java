package com.assure.movie.model.repository;

import com.assure.movie.model.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Israel Yasis
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
