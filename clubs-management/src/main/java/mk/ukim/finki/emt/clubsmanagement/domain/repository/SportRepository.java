package mk.ukim.finki.emt.clubsmanagement.domain.repository;

import mk.ukim.finki.emt.clubsmanagement.domain.models.Sport;
import mk.ukim.finki.emt.clubsmanagement.domain.models.SportId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportRepository extends JpaRepository<Sport, SportId> {
}
