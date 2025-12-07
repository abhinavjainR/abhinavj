package com.hrservices.hrservicesbackend.Repositories;

import com.hrservices.hrservicesbackend.Entity.RewardRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RewardRepository extends JpaRepository<RewardRecord, Long> {
    List<RewardRecord> findByEmployeeId(Long employeeId);
    List<RewardRecord> findByRewardTitle(String rewardTitle);
}
