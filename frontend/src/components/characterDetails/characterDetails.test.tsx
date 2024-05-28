import { render, screen } from "@testing-library/react";
import { CharacterDetailsDto } from "../../clients/models";
import { act } from "react";
import CharacterDetails from "./characterDetails";

test("Should expand films accordion", () => {
  // Given
  const character = {
    id: "uuid-1",
    name: "character-name-1",
    height: 1,
    mass: 2,
    hairColor: "hair-color-1",
    skinColor: "skin-color-1",
    eyeColor: "eye-color-1",
    birthYear: "birth-year-1",
    gender: "gender-1",
    imageUrl: "character/image-1.jpg",
    homeworld: {
      id: "uuid-2",
      name: "planet-1",
      imageUrl: "planets/image-1.jpg",
    },
    films: [
      {
        id: "uuid-3",
        title: "title-1",
        episode: 1,
        imageUrl: "films/image-1.jpg",
      },
    ],
    species: [
      {
        id: "uuid-4",
        name: "specie-1",
        imageUrl: "species/image-1.jpg",
      },
    ],
    starships: [
      {
        id: "uuid-5",
        name: "starship-1",
        imageUrl: "starships/image-1.jpg",
      },
    ],
    vehicles: [
      {
        id: "uuid-6",
        name: "vehicle-1",
        imageUrl: "vehicles/image-1.jpg",
      },
    ],
  } as CharacterDetailsDto;

  // When
  render(<CharacterDetails character={character} key={character.id} />);

  // Then
  const button = screen.getByText("In Films");
  const accordion =
    button.parentElement?.parentElement?.getElementsByClassName(
      "accordion-collapse"
    )[0];

  expect(button).toBeInTheDocument();
  expect(button).toHaveAttribute("aria-expanded", "false");

  expect(accordion).toBeInTheDocument();
  expect(accordion).not.toHaveClass("show");

  act(() => button.click());

  expect(button).toBeInTheDocument();
  expect(button).toHaveAttribute("aria-expanded", "true");

  expect(accordion).toBeInTheDocument();
  expect(accordion).toHaveClass("collapsing");
});
