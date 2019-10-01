package ca.sergei.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import ca.sergei.restservice.entity.Address;


@Repository
//@RequestMapping(path = "/address")
public interface AddressRepository extends JpaRepository<Address, Long>{

}

