type ProductCardProps = {
  id: string;
  name: string;
  price: number;
  imageUrl: string;
};

import Link from "next/link";

export default function ProductCard({ id, name, price, imageUrl }: ProductCardProps) {
  return (
    <div className="bg-white rounded-lg shadow-md hover:shadow-lg transition duration-300 p-4 flex flex-col">
      <img
        src={imageUrl}
        alt={name}
        className="w-full h-48 object-contain mb-4 rounded"
      />
      <h3 className="text-gray-800 font-semibold text-lg line-clamp-2">{name}</h3>
      <p className="text-blue-600 font-bold text-xl mt-2">฿{price.toLocaleString()}</p>

      <Link
        href={`/products/${id}`}
        className="mt-auto text-center bg-blue-600 hover:bg-blue-500 text-white py-2 rounded-md font-medium transition"
      >
        ดูรายละเอียด
      </Link>
    </div>
  );
}