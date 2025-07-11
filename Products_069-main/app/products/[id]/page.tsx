import { products } from '@/data/products';
import ProductDetail from '@/components/ProductDetail';

type Props = {
  params: {
    id: string;
  };
};

export default function ProductDetailPage({ params }: Props) {
  const product = products.find(p => p.id === params.id);

  if (!product) return <div className="p-6">ไม่พบสินค้า</div>;

  return (
    <main className="p-6">
      <ProductDetail {...product} />
    </main>
  );
}