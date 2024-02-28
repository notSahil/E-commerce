import React, { useEffect, useState } from "react";
import { useDispatch } from "react-redux";
import axios from "axios";
import ProductCard from "../ProductCard/ProductCard";
import { API_BASE_URL } from "../../../../config/api";

const ProductPage = () => {
  const dispatch = useDispatch();
  const [products, setProducts] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchProducts = async () => {
      setLoading(true);
      try {
        const response = await axios.get(`${API_BASE_URL}/api/products/all`);
        setProducts(response.data);
        dispatch({ type: 'UPDATE_PRODUCTS', payload: response.data });
      } catch (error) {
        setError(error.message);
      }
      setLoading(false);
    };

    fetchProducts();
  }, [dispatch]);

  if (loading) {
    return <div>Loading...</div>;
  }

  if (error) {
    return <div>Error: {error}</div>;
  }

  return (
    <div className="px-10 -z-10">
      <div className="flex justify-between py-5">
        <p className="font-bold">Filter</p>
        <p>Sort</p>
      </div>

      <div className="flex justify-between">
        <div className="w-[20%] border rounded-md bg-white"></div>
        <div className="flex flex-wrap justify-between w-[78%] bg-white border p-5 rounded-md">
          {products.map((product) => (
            <ProductCard key={product.id} product={product} />
          ))}
        </div>
      </div>
    </div>
  );
};

export default ProductPage;
