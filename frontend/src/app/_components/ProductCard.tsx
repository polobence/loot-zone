"use client";

import Image from "next/image";
import Link from "next/link";

interface ProductCardProps {
  product: {
    publicId: string;
    name: string;
    price: number;
    imageUrl: string;
    category: string;
  };
}

export default function ProductCard({ product }: ProductCardProps) {
  return (
    <Link href={`/products/${product.publicId}`}>
      <div className="border rounded-xl p-4 shadow hover:shadow-lg transition cursor-pointer">
        <Image
          src={product.imageUrl}
          alt={product.name}
          className="w-full h-48 object-cover rounded-lg mb-4"
          width={500}
          height={300}
        />
        <h2 className="text-lg font-semibold rainbow-text">{product.name}</h2>
        <p className="text-gray-600">{product.category}</p>
        <p className="font-bold mt-2">${product.price.toFixed(2)}</p>
      </div>
    </Link>
  );
}
