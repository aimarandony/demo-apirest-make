package com.d4si.api.attendance.repository;

import com.d4si.api.attendance.domain.StudentAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentAttendanceRepository extends JpaRepository<StudentAttendance,Long> {
}
