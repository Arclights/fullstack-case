import { useLoaderData } from "react-router-dom";
import { fetchCharacter } from "../../clients/characterClient";
import { CharacterDetailsDto } from "../../clients/models";
import CharacterDetails from "../../components/characterDetails/characterDetails";
import './characterPage.css'

export default () => {
  const character = useLoaderData() as CharacterDetailsDto;
  return (
    <div>
      <div className="header">{character.name}</div>
      <div className="character-content">
        <CharacterDetails character={character} />
      </div>
    </div>
  );
};

export async function loadCharacter({ params }: { params: any }) {
  return fetchCharacter(params.characterId);
}
