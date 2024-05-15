package mk.ukim.finki.emt.clubsmanagement.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.clubsmanagement.domain.models.*;
import mk.ukim.finki.emt.clubsmanagement.domain.repository.ClubRepository;
import mk.ukim.finki.emt.clubsmanagement.domain.repository.SportCategoryRepository;
import mk.ukim.finki.emt.clubsmanagement.domain.repository.SportRepository;
import mk.ukim.finki.emt.clubsmanagement.services.ClubService;
import mk.ukim.finki.emt.clubsmanagement.services.forms.ClubForm;
import mk.ukim.finki.emt.clubsmanagement.services.forms.SportForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;
    private final SportRepository sportRepository;
    private final SportCategoryRepository sportCategoryRepository;
    private final Validator validator;

    @Override
    public ClubId addClub(ClubForm clubForm) throws URISyntaxException {
        Objects.requireNonNull(clubForm, "The club must not be null.");
        var constraintViolations = validator.validate(clubForm);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException("The club form is not valid", constraintViolations);
        }

        var club = toDomainObject(clubForm);
        var newClub = clubRepository.saveAndFlush(club);

        return newClub.getId();
    }

    @Override
    public List<Club> findAll() {
        return null;
    }

    @Override
    public Optional<Club> findById() {
        return Optional.empty();
    }

    @Override
    public void updateClubDetails(ClubForm clubForm) {

    }

    @Override
    public void addSportToClub(ClubId clubId, SportForm sportForm) {

    }

    @Override
    public void removeSportFromClub(ClubId clubId, SportId sportId) {

    }

    private Club toDomainObject(ClubForm clubForm) throws URISyntaxException {
        var website = new URI(clubForm.getWebsite());

        var sports = new HashSet<Sport>();
        for (var sport : clubForm.getSports()) {
            Sport fetchedSport;

            if (sport.getId() != null) {
                fetchedSport = sportRepository.findById(sport.getId()).orElseThrow();
                sports.add(fetchedSport);
                continue;
            }

            fetchedSport = new Sport(sport.getName(), sport.getDescription(), sport.getCategories().stream().map(sportCategoryForm ->
                    new SportCategory(sportCategoryForm.getName())).collect(Collectors.toSet()));
            sports.add(fetchedSport);
        }

        return new Club(
                clubForm.getName(),
                clubForm.getDescription(),
                website,
                clubForm.getPhoneNumber(),
                clubForm.getAddress(),
                sports);
    }
}
