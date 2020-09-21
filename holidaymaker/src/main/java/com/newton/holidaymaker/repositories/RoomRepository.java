package com.newton.holidaymaker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.newton.holidaymaker.models.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>{
    @Query("SELECT DISTINCT roomType FROM Room")
    List<String> findAllRoomTypes();
}
