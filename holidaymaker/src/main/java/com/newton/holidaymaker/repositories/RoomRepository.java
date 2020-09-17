package com.newton.holidaymaker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newton.holidaymaker.models.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>{

}
//git problem