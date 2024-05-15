package mk.ukim.finki.emt.clubsmanagement.domain.repository;

import mk.ukim.finki.emt.clubsmanagement.domain.models.SportCategory;
import mk.ukim.finki.emt.clubsmanagement.domain.models.SportCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportCategoryRepository extends JpaRepository<SportCategory, SportCategoryId> {
}
