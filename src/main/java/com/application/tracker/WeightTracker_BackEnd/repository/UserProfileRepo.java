package com.application.tracker.WeightTracker_BackEnd.repository;

import com.application.tracker.WeightTracker_BackEnd.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepo extends JpaRepository<User, Long> {

    User findByEmailId(String email);
}
