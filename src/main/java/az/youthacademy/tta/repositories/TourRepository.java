package az.youthacademy.tta.repositories;

import az.youthacademy.tta.entities.Tours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<Tours, Long> {
    Tours findOneByTitle(String title);
}
