export type PaginationResponse<T> = {
  items: [T];
  pageNumber: number;
  pageSize: number;
  totalPages: number;
};

export type CharacterListingDto = {
  id: string;
  name: string;
  imageUrl: string;
};

export type CharacterDetailsDto = {
  id: string;
  name: string;
  height: number;
  mass: number;
  hairColor: string;
  skinColor: string;
  eyeColor: string;
  birthYear: string;
  gender: string;
  imageUrl: string;
  homeworld: PlanetListingDto;
  films: FilmListingDto[];
  species: SpeciesListingDto[];
  starships: StarshipListing[];
  vehicles: VehicleListingDto[];
};

export type PlanetListingDto = {
  id: string;
  name: string;
  imageUrl: string;
};

export type FilmListingDto = {
  id: string;
  title: string;
  episode: number;
  imageUrl: string;
};

export type SpeciesListingDto = {
  id: string;
  name: string;
  imageUrl: string;
};

export type StarshipListing = {
  id: string;
  name: string;
  imageUrl: string;
};

export type VehicleListingDto = {
  id: string;
  name: string;
  imageUrl: string;
};
