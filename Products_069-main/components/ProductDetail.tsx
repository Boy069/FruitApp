type ProductDetailProps = {
  name: string;
  price: number;
  imageUrl: string;
  description: string;
};

export default function ProductDetail({ name, price, imageUrl, description }: ProductDetailProps) {
  return (
    <div className="bg-white rounded-xl shadow-xl border border-blue-300 p-6 max-w-3xl mx-auto">
      <div className="grid md:grid-cols-2 gap-6">
        {/* รูปภาพ */}
        <img
          src={imageUrl}
          alt={name}
          className="w-full h-auto object-contain rounded-lg border border-gray-200"
        />

        {/* รายละเอียด */}
        <div className="flex flex-col justify-between">
          <div>
            <h2 className="text-3xl font-bold text-blue-700 mb-2">{name}</h2>
            <p className="text-gray-500 text-sm mb-4">รหัสสินค้า: xxx123456</p>
            <p className="text-2xl font-semibold text-green-600 mb-4">฿ {price.toLocaleString()} บาท</p>
            <p className="text-gray-700 leading-relaxed">{description}</p>
          </div>

          <button className="mt-6 bg-blue-600 hover:bg-blue-500 text-white font-semibold py-3 px-6 rounded-md transition duration-300 shadow-md hover:scale-105">
            หยิบใส่ตะกร้า 🛒
          </button>
        </div>
      </div>
    </div>
  );
}
