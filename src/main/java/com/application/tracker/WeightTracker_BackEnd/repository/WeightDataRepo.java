package com.application.tracker.WeightTracker_BackEnd.repository;

import com.application.tracker.WeightTracker_BackEnd.beans.WeightData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeightDataRepo extends JpaRepository<WeightData, Long> {
}
