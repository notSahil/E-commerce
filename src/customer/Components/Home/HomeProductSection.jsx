import AliceCarousel from "react-alice-carousel";
import HomeProductCard from "./HomeProductCard";
import "./HomeProductSection.css";
import { Button } from "@mui/material";
import ArrowForwardIosIcon from "@mui/icons-material/ArrowForwardIos";
import { useState } from "react";

const HomeProductSection = ({ section, data }) => {
  const [activeIndex, setActiveIndex] = useState(0);

  const slidePrev = () => setActiveIndex(activeIndex - 1);
  const slideNext = () => setActiveIndex(activeIndex + 1);
  const syncActiveIndex = ({ item }) => setActiveIndex(item);

  const items = data?.slice(0, 10).map((item) => (
    <div className="home-product-card">
      <HomeProductCard product={item} />
    </div>
  ));

  return (
    <div className="relative px-4 sm:px-6 lg:px-8">
      <h2 className="text-2xl font-extrabold text-gray-900 py-5">{section}</h2>
      <AliceCarousel
        mouseTracking
        items={items}
        activeIndex={activeIndex}
        onInitialized={syncActiveIndex}
        onSlideChanged={syncActiveIndex}
        onResized={syncActiveIndex}
        controlsStrategy="responsive"
        disableButtonsControls
        disableDotsControls
      />
    </div>
  );
};

export default HomeProductSection;
