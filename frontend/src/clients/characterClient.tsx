import { baseUrl } from "../configuration";
import {
  CharacterDetailsDto,
  CharacterListingDto,
  PaginationResponse,
} from "./models";

export async function fetchCharacters(
  page?: string,
  pageSize?: string
): Promise<PaginationResponse<CharacterListingDto>> {
  const pageQuery = `pageNumber=${page ?? 0}`;
  const pageSizeQuery = `pageSize=${pageSize ?? 10}`;
  return fetch(`${baseUrl}/characters?${pageQuery}&${pageSizeQuery}`, {
    method: "GET",
    mode: "cors",
  }).then((response) => response.json());
}

export async function fetchCharacter(id: string): Promise<CharacterDetailsDto> {
  return fetch(`${baseUrl}/characters/${id}`, {
    method: "GET",
    mode: "cors",
  }).then((response) => response.json());
}
