package cinema;

import models.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import requests.ChoosePlace;
import requests.DeletePlace;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class CinemaController {

    private final int maxValuer = 9;
    private final Cinema cinema = new Cinema(maxValuer, maxValuer, setGrid(maxValuer, maxValuer));
    private final EmptyHoll emptyHoll = new EmptyHoll(maxValuer, maxValuer, setGrid(maxValuer));

    @GetMapping(value = "/seats", produces = APPLICATION_JSON_VALUE)
    public EmptyHoll getCinema() {
        return emptyHoll;
    }

    public List<Ticket> setGrid(int row) {
        List<Ticket> current = new java.util.ArrayList<>(List.of());

        int column = row;

        for (int current_row = 0; current_row < row; current_row++) {
            for (int current_column = 0; current_column < column; current_column++) {

                Ticket ticket = new Ticket(current_row + 1, current_column + 1, 8);

                if (current_row < 4) {
                    ticket.setPrice(10);
                }

                current.add(ticket);
            }
        }
        return current;
    }

    public List<Place> setGrid(int row, int column) {
        List<Place> current = new java.util.ArrayList<>(List.of());

        for (int current_row = 0; current_row < row; current_row++) {
            for (int current_column = 0; current_column < column; current_column++) {

                String token = String.valueOf(UUID.randomUUID());
                Ticket ticket = new Ticket(current_row + 1, current_column + 1, 8);

                if (current_row < 4) {
                    ticket.setPrice(10);
                }

                current.add(new Place(token, ticket));
            }
        }
        return current;
    }


    @PostMapping(value = "/purchase", produces = APPLICATION_JSON_VALUE)
    public Place takePlace(@RequestBody ChoosePlace choosePlace) {
        int row = choosePlace.getRow();
        int column = choosePlace.getColumn();

        int minValuer = 1;

        if (row > maxValuer || row < minValuer || column > maxValuer || column < minValuer) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The number of a row or a column is out of bounds!");
        }

        int index = (row - 1) * 9 + (column - 1);
        boolean placeFree = cinema.getAvailable_seats().get(index).ifFree();
        Place currentPlace = cinema.getAvailable_seats().get(index);

        if (!placeFree) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The ticket has been already purchased!");
        }

        currentPlace.freePlace(false);
        return currentPlace;
    }

    @PostMapping(value = "/return", produces = APPLICATION_JSON_VALUE)
    public Map<String, Ticket> deletePlace(@RequestBody DeletePlace deletePlace) {
        for (Place place : cinema.getAvailable_seats()) {
            if (deletePlace.getToken().equals(place.getToken()) && !place.ifFree()) {
                place.freePlace(true);
                return Map.of("returned_ticket", place.getTicket());
            }
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wrong token!");
    }

    @PostMapping(value = "/stats")
    public Statistics showStatistics(@RequestParam(value = "password", required = false) String value) {

        if (value == null || !value.equals("super_secret")) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "The password is wrong!");
        } else {

            int income = 0;
            int occupiedPlace = 0;

            for (Place place : cinema.getAvailable_seats()) {
                if (!place.ifFree()) {
                    income += place.getTicket().getPrice();
                    occupiedPlace++;
                }
            }

            return new Statistics(income, cinema.getAvailable_seats().size() - occupiedPlace, occupiedPlace);
        }
    }

}
