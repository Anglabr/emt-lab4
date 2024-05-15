package mk.ukim.finki.emt.clubsmanagement.services;

import mk.ukim.finki.emt.clubsmanagement.domain.models.Club;
import mk.ukim.finki.emt.clubsmanagement.domain.models.ClubId;
import mk.ukim.finki.emt.clubsmanagement.domain.models.SportId;
import mk.ukim.finki.emt.clubsmanagement.services.forms.ClubForm;
import mk.ukim.finki.emt.clubsmanagement.services.forms.SportForm;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

public interface ClubService {
    ClubId addClub(ClubForm clubForm) throws URISyntaxException;

    List<Club> findAll();

    Club findById(ClubId clubId);

    void updateClubGeneralInformation(ClubId clubId, ClubForm clubForm);

    void addSportToClub(ClubId clubId, SportForm sportForm);

    void removeSportFromClub(ClubId clubId, SportId sportId);
}
