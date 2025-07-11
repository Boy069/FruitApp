import ProductList from '@/components/ProductList';

export default function ProductsPage() {
    return (
        <main className="p-6 bg-neutral-900 text-white min-h-screen">
            <h1 className="text-2xl font-bold mb-4">สินค้าเมาส์เกมมิ่ง</h1>
            <ProductList />
        </main>
    );
}