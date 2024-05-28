import { Accordion, Card, ListGroup } from "react-bootstrap";
import { CharacterDetailsDto } from "../../clients/models";
import Listing from "../listing/listing";
import AccordionListing from "../accordionListing";
import AccordionFilmsListing from "../accordionFilmsListing";
import { baseUrl } from "../../configuration";
import './characterDetails.css'

export default ({ character }: { character: CharacterDetailsDto }) => (
  <Card className="character-details">
    <Card.Img src={`${baseUrl}/images/${character.imageUrl}`}/>
    <Card.Body>
      <ListGroup>
        <ListGroup.Item>Height: {character.height}</ListGroup.Item>
        <ListGroup.Item>Mass: {character.mass}</ListGroup.Item>
        <ListGroup.Item>Hair Color: {character.hairColor}</ListGroup.Item>
        <ListGroup.Item>Skin Color: {character.skinColor}</ListGroup.Item>
        <ListGroup.Item>Eye Color: {character.eyeColor}</ListGroup.Item>
        <ListGroup.Item>Birth Year: {character.birthYear}</ListGroup.Item>
        <ListGroup.Item>Gender: {character.gender}</ListGroup.Item>
        <ListGroup.Item className="homeworld-content">
          <div>Homeworld: </div>
          <Listing
            image={character.homeworld.imageUrl}
            text={character.homeworld.name}
          />
        </ListGroup.Item>
      </ListGroup>
      <Accordion>
        <AccordionFilmsListing
          title="In Films"
          films={character.films}
          eventKey="0"
        />
        <AccordionListing
          title="Is Specie"
          listings={character.species}
          eventKey="1"
        />
        <AccordionListing
          title="Is Driving"
          listings={character.vehicles}
          eventKey="2"
        />
        <AccordionListing
          title="Is Piloting"
          listings={character.starships}
          eventKey="3"
        />
      </Accordion>
    </Card.Body>
  </Card>
);
