package com.ciandt.pokeapifakeservice.entrypoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.ciandt.pokeapifakeservice.entrypoint.models.PokemonViewModel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokeFakeController {

        @GetMapping("/starter")
        public ResponseEntity<List<PokemonViewModel>> getStarterPokemons(@RequestParam Integer season) {

                PokemonViewModel starterPoke1;
                PokemonViewModel starterPoke2;
                PokemonViewModel starterPoke3;
                List<PokemonViewModel> kantoStarterPokemons;

                if (season.equals(1)) {
                        starterPoke1 = PokemonViewModel.builder()
                                        .base_experience(64)
                                        .height(7)
                                        .id(1)
                                        .is_default(true)
                                        .location_area_encounters("https://pokeapi.co/api/v2/pokemon/1/encounters")
                                        .weight(69)
                                        .name("Bulbasaur").build();

                        starterPoke2 = PokemonViewModel.builder()
                                        .base_experience(63)
                                        .height(5)
                                        .id(7)
                                        .is_default(true)
                                        .location_area_encounters("https://pokeapi.co/api/v2/pokemon/7/encounters")
                                        .weight(90)
                                        .name("Squirtle").build();

                        starterPoke3 = PokemonViewModel.builder()
                                        .base_experience(62)
                                        .height(6)
                                        .id(4)
                                        .is_default(true)
                                        .location_area_encounters("https://pokeapi.co/api/v2/pokemon/4/encounters")
                                        .weight(85)
                                        .name("Charmander").build();

                        kantoStarterPokemons = Arrays.asList(starterPoke1, starterPoke2, starterPoke3);
                } else {
                        kantoStarterPokemons = new ArrayList<>();
                }

                return ResponseEntity.ok().body(kantoStarterPokemons);
        }

        @GetMapping("/{pokeName}")
        public ResponseEntity<PokemonViewModel> getPokemonDetails(@PathVariable String pokeName) throws InterruptedException {

                PokemonViewModel starterPoke1 = PokemonViewModel.builder()
                                .base_experience(64)
                                .height(7)
                                .id(1)
                                .is_default(true)
                                .location_area_encounters("https://pokeapi.co/api/v2/pokemon/1/encounters")
                                .weight(69)
                                .name("Bulbasaur").build();

                PokemonViewModel starterPoke2 = PokemonViewModel.builder()
                                .base_experience(63)
                                .height(5)
                                .id(7)
                                .is_default(true)
                                .location_area_encounters("https://pokeapi.co/api/v2/pokemon/7/encounters")
                                .weight(90)
                                .name("Squirtle").build();

                PokemonViewModel starterPoke3 = PokemonViewModel.builder()
                                .base_experience(62)
                                .height(6)
                                .id(4)
                                .is_default(true)
                                .location_area_encounters("https://pokeapi.co/api/v2/pokemon/4/encounters")
                                .weight(85)
                                .name("Charmander").build();

                List<PokemonViewModel> kantoStarterPokemons = Arrays.asList(starterPoke1, starterPoke2, starterPoke3);

                PokemonViewModel desiredPokemon = kantoStarterPokemons.stream()
                                .filter(poke -> pokeName.toLowerCase().equals(poke.getName().toLowerCase())).findFirst()
                                .orElse(null);

                Thread.sleep(10000);

                return Objects.nonNull(desiredPokemon) ? ResponseEntity.ok().body(desiredPokemon)
                                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

}
