package ca.sergei.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import ca.sergei.restservice.entity.Passenger;

@Repository
//@RequestMapping(path = "/passengers")
public interface PassengerRepository extends JpaRepository<Passenger, Long>{

}
