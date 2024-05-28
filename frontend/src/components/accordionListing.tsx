import { Accordion } from "react-bootstrap";
import Listing from "./listing/listing";

export default ({
  listings,
  title,
  eventKey,
}: {
  listings: { imageUrl: string; name: string }[];
  title: string;
  eventKey: string;
}) => (
  <Accordion.Item eventKey={eventKey}>
    <Accordion.Header>{title}</Accordion.Header>
    <Accordion.Body>
      {listings.map((listing) => (
        <Listing image={listing.imageUrl} text={listing.name} />
      ))}
    </Accordion.Body>
  </Accordion.Item>
);
