package es.urjc.etsii.mtenrero.Repositories;


import es.urjc.etsii.mtenrero.Entities.Pet_Breed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by was12 on 04/02/2017.
 */
public interface Pet_BreedRepository extends JpaRepository<Pet_Breed, Long> {
    List<Pet_Breed> findByBreed(String breed);
}

