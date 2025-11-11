import Image from "next/image";

interface Product {
  publicId: string;
  name: string;
  category: string;
  price: number;
  imageUrl: string;
  description: string;
}

export default async function ProductDetails({ params }: { params: Promise<{ id: string }> }) {
  const { id } = await params;

  const res = await fetch(`${process.env.NEXT_PUBLIC_API}/products/${id}`, {
    cache: "no-store",
  });

  if (!res.ok) {
    return <p className="text-center text-red-500">Product not found.</p>;
  }

  const product: Product = await res.json();

  return (
    <div className="p-6 max-w-3xl mx-auto">
      <div className="flex flex-col md:flex-row gap-6">
        <Image
          src={product.imageUrl}
          alt={product.name}
          width={500}
          height={300}
          className="rounded-lg object-cover w-full md:w-1/2"
        />

        <div>
          <h1 className="text-3xl font-bold mb-2">{product.name}</h1>
          <p className="text-gray-600 mb-2">{product.category}</p>
          <p className="text-xl font-semibold mb-4">${product.price.toFixed(2)}</p>
          <p className="text-gray-700">{product.description}</p>
        </div>
      </div>
    </div>
  );
}
