import { useLoaderData, useSearchParams } from "react-router-dom";
import { fetchCharacters } from "../../clients/characterClient";
import { CharacterListingDto, PaginationResponse } from "../../clients/models";
import CharacterListings from "../../components/characterListings/characterListings";
import "./rootPage.css";

export default () => {
  const [_, setSearchParams] = useSearchParams();
  const characters = useLoaderData() as PaginationResponse<CharacterListingDto>;
  return (
    <div>
      <div className="header">Star Wars Characters</div>
      <div className="content">
        <CharacterListings
          characterResponse={characters}
          setPage={(pageNumber: Number) =>
            setSearchParams(`page=${pageNumber}`)
          }
        />
      </div>
    </div>
  );
};

export async function loadCharacters({ request }: { request: any }) {
  const url = new URL(request.url);
  const page = url.searchParams.get("page") ?? undefined;
  const pageSize = url.searchParams.get("pageSize") ?? undefined;
  return await fetchCharacters(page, pageSize);
}
