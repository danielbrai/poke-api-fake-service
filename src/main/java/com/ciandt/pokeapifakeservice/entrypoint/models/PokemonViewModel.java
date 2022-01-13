package com.ciandt.pokeapifakeservice.entrypoint.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PokemonViewModel {
    public int base_experience;
    public int height;
    public int id;
    public boolean is_default;
    public String location_area_encounters;
    public String name;
    public int weight;
}
