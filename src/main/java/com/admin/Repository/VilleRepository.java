package com.admin.Repository;

import com.admin.models.Ville;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VilleRepository extends JpaRepository<Ville, Long> {

    @Query("FROM Ville")
    List<Ville> findAllOrderByNomVilleAsc(Sort sort);

}
