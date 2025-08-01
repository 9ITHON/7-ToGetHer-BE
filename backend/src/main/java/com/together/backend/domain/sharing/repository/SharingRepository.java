package com.together.backend.domain.sharing.repository;

import com.together.backend.domain.sharing.model.entity.Sharing;
import com.together.backend.domain.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SharingRepository extends JpaRepository<Sharing, Long> {
    Optional<Sharing> findByUser(User user);

    void deleteByUser(User user);
}
