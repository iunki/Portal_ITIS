package org.itis.portal.repository;

import org.itis.portal.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by thefp on 22.04.2017.
 */
@Repository
public interface TimeTableRepository extends JpaRepository<Schedule, Long> {
    @Query("select sch from Schedule sch join sch.group as group join sch.subjects as subject where group.groupNumber=:groupNumber and sch.day=:day")
    List<Schedule> findAllByGroupOnDay(@Param("groupNumber") String groupNumber, @Param("day") Integer day);

    @Query("select sch from Schedule sch join sch.group as group join sch.subjects as subject where sch.group.groupNumber=:groupNumber")
    List<Schedule> findAllByGroupOnWeek(@Param("groupNumber") String groupNumber);

    @Query("select sch from Schedule sch join sch.group as group join sch.subjects as subject where subject.teacher like CONCAT(CONCAT('%',:teacher),'%') and sch.day=:day")
    List<Schedule> findAllByTeacherOnDay(@Param("teacher") String teacher, @Param("day") Integer day);

    @Query("select sch from Schedule sch join sch.group as group join sch.subjects as subject where subject.teacher like CONCAT(CONCAT('%',:teacher),'%')")
    List<Schedule> findAllByTeacherOnWeek(@Param("teacher") String teacher);

    @Query("select sch from Schedule sch join sch.group as group join sch.subjects as subject where (sch.startDate=:time or sch.endDate=:time) and sch.day=:day")
    List<Schedule> findAllByTimeOnDay(@Param("time") String time, @Param("day") Integer day);

    @Query("select sch from Schedule sch join sch.group as group join sch.subjects as subject where (sch.startDate=:time or sch.endDate=:time)")
    List<Schedule> findAllByTimeOnWeek(@Param("time") String time);

    @Query("select sch from Schedule sch join sch.group as group join sch.subjects as subject where subject.room like CONCAT(CONCAT('%',:room),'%') and sch.day=:day")
    List<Schedule> findAllByRoomOnDay(@Param("room") String room, @Param("day") Integer day);

    @Query("select sch from Schedule sch join sch.group as group join sch.subjects as subject where subject.room like CONCAT(CONCAT('%',:room),'%')")
    List<Schedule> findAllByRoomOnWeek(@Param("room") String room);
}
