import { baseUrl } from "../../configuration";
import './filmsListing.css'

export default ({
  image,
  title,
  episode,
}: {
  image: string;
  title: string;
  episode: number;
}) => (
  <div className="film-listing">
    <img src={`${baseUrl}/images/${image}`} />
    <div>
      <div>Episode {episode}</div>
      <div>{title}</div>
    </div>
  </div>
);
