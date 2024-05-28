import { baseUrl } from "../../configuration";
import "./listing.css";

export default ({ image, text }: { image: string; text: string }) => (
  <div className="listing">
    <img src={`${baseUrl}/images/${image}`} />
    <div>{text}</div>
  </div>
);
