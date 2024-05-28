import { Accordion } from "react-bootstrap";
import FilmsListing from "./filmsListing/filmsListing";

export default ({
  films,
  title,
  eventKey,
}: {
  films: { imageUrl: string; title: string; episode: number }[];
  title: string;
  eventKey: string;
}) => (
  <Accordion.Item eventKey={eventKey}>
    <Accordion.Header>{title}</Accordion.Header>
    <Accordion.Body>
      {films.map((film) => (
        <FilmsListing
          image={film.imageUrl}
          title={film.title}
          episode={film.episode}
        />
      ))}
    </Accordion.Body>
  </Accordion.Item>
);
