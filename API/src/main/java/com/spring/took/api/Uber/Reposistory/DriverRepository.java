package com.spring.took.api.Uber.Reposistory;

import com.spring.took.api.Uber.Entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
Optional<Driver> findByIdAndLicenseNumber(long id  , String licenseNumber);
@Query(nativeQuery = true,
value = "select * from driver where id= :id and license_number = :licenceNumber")
Driver  findbyDriverIdWithLicence(long id , String licenceNumber);

    @Query("select d from  Driver d where d.id = :id and d.licenseNumber = :ln")
    Driver  HibernatefindbyDriverIdWithLicence(long id , String ln);

List<Driver> findAllByIdIn(List<Long> driverId);

}