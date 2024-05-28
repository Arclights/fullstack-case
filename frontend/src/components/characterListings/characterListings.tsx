import React from "react";
import { CharacterListingDto, PaginationResponse } from "../../clients/models";
import "./characterListings.css";
import { Stack } from "react-bootstrap";
import PaginationComponent from "../paginationComponent";
import CharacterListing from "../characterListing/characterListing";

export default ({
  characterResponse,
  setPage,
}: {
  characterResponse: PaginationResponse<CharacterListingDto>;
  setPage: (pageNumber: Number) => void;
}) => (
  <div className="character-listings">
    <Stack gap={3} direction="horizontal">
      {characterResponse.items.map((character) => (
        <CharacterListing characterData={character} key={character.id} />
      ))}
    </Stack>
    <PaginationComponent
      pageNumber={characterResponse.pageNumber}
      totalNumberOfPages={characterResponse.totalPages}
      setPage={setPage}
    />
  </div>
);
