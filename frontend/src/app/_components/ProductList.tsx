"use client";

import { useEffect, useState } from "react";
import ProductCard from "./ProductCard";

interface Product {
  publicId: string;
  name: string;
  price: number;
  description: string;
  imageUrl: string;
  category: string;
}

const ProductList: React.FC = () => {
  const [products, setProducts] = useState<Product[]>([]);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const response = await fetch(`${process.env.NEXT_PUBLIC_API}/products`);
        if (!response.ok) throw new Error("Failed to fetch products");
        const data: Product[] = await response.json();
        setProducts(data);
      } catch (err: unknown) {
        if (err instanceof Error) setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    fetchProducts();
  }, []);

  if (loading) return <p className="text-center mt-8">Loading products...</p>;
  if (error) return <p className="text-center mt-8 text-red-500">{error}</p>;

  return (
    <div className="p-6">
      <h1 className="text-2xl font-bold mb-6 text-center">Products</h1>

      <div className="grid gap-6 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4">
        {products.map((product) => (
          <ProductCard key={product.publicId} product={product} />
        ))}
      </div>
    </div>
  );
};

export default ProductList;
