package com.technogise.leave_management_system.specification;

import com.technogise.leave_management_system.entity.Leave;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public class LeaveSpecification {
    public static Specification<Leave> notDeleted() {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.isNull(root.get("deletedAt"));
    }

    public static Specification<Leave> allLeavesOfEmployee(UUID userId) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("user").get("id"), userId);
    }

    public static Specification<Leave> noFilter() {
        return (root, query, cb) -> cb.conjunction();
    }
}
