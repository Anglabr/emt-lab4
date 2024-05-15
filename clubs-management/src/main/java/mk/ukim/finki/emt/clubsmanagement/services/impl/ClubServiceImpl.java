package mk.ukim.finki.emt.clubsmanagement.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.clubsmanagement.domain.exceptions.ClubIdNotFoundException;
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
        return clubRepository.findAll();
    }

    @Override
    public Club findById(ClubId clubId) {
        return clubRepository.findById(clubId).orElseThrow(ClubIdNotFoundException::new);
    }

    @Override
    public void updateClubGeneralInformation(ClubId clubId, ClubForm clubForm) {
        Objects.requireNonNull(clubForm, "The club must not be null.");
        Club club = clubRepository.findById(clubId).orElseThrow(ClubIdNotFoundException::new);
        // update general info
        clubRepository.saveAndFlush(club);
    }

    @Override
    public void addSportToClub(ClubId clubId, SportForm sportForm) {
        Club club = clubRepository.findById(clubId).orElseThrow(ClubIdNotFoundException::new);
        Sport sport;
        if (sportForm.getId() != null) {
            sport = sportRepository.findById(sportForm.getId()).orElseThrow();
        }
        else {
            sport = new Sport(sportForm.getName(), sportForm.getDescription(), sportForm.getCategories().stream().map(sportCategoryForm ->
                    new SportCategory(sportCategoryForm.getName())).collect(Collectors.toSet()));
        }
        // club add sport
        clubRepository.saveAndFlush(club);
    }

    @Override
    public void removeSportFromClub(ClubId clubId, SportId sportId) {
        Club club = clubRepository.findById(clubId).orElseThrow(ClubIdNotFoundException::new);
        // club remove sport
        clubRepository.saveAndFlush(club);
    }

    private Club toDomainObject(ClubForm clubForm) throws URISyntaxException {
        var website = new URI(clubForm.getWebsite());

        var sports = getSports(clubForm);

        return new Club(
                clubForm.getName(),
                clubForm.getDescription(),
                website,
                clubForm.getPhoneNumber(),
                clubForm.getAddress(),
                sports);
    }

    private Set<Sport> getSports(ClubForm clubForm) {
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

        return sports;
    }
}
