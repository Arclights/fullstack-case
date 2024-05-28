import { Link } from "react-router-dom";
import { CharacterListingDto } from "../../clients/models";
import { Card } from "react-bootstrap";
import { baseUrl } from "../../configuration";
import "./characterListing.css";

export default ({ characterData }: { characterData: CharacterListingDto }) => (
  <Link to={`/characters/${characterData.id}`} className="character-listing">
    <Card>
      <Card.Img
        variant="top"
        src={`${baseUrl}/images/${characterData.imageUrl}`}
      />
      <Card.Body>
        <Card.Title>{characterData.name}</Card.Title>
      </Card.Body>
    </Card>
  </Link>
);
