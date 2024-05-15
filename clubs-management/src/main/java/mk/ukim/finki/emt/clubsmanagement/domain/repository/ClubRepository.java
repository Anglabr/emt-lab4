package mk.ukim.finki.emt.clubsmanagement.domain.repository;

import mk.ukim.finki.emt.clubsmanagement.domain.models.Club;
import mk.ukim.finki.emt.clubsmanagement.domain.models.ClubId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, ClubId> {
}
