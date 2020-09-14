package com.newton.holidaymaker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.newton.holidaymaker.models.Room;

public interface RoomRepository extends JpaRepository<Room,  Integer>{

}
//