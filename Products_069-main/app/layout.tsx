import "./globals.css";
import Link from "next/link";
import { FaHome, FaBoxOpen } from 'react-icons/fa';

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body className="bg-gradient-to-tr from-gray-50 to-gray-200 min-h-screen text-gray-800 font-sans">
        <nav className="bg-white shadow-md sticky top-0 z-50 px-6 py-4 flex gap-6 items-center border-b">
          <Link href="/" className="flex items-center gap-2 text-gray-700 hover:text-blue-600 font-semibold transition"><FaHome />หน้าหลัก</Link>
          <Link href="/products" className="flex items-center gap-2 text-gray-700 hover:text-blue-600 font-semibold transition"><FaBoxOpen />แสดงสินค้า</Link>
        </nav>
        <main>{children}</main>
        <footer className="bg-white border-t mt-10 text-center py-6 text-sm text-gray-500">
          <p>&copy; 2025 ร้านเมาส์เกมมิ่ง | Veerawat Ainplot </p>
        </footer>
      </body>
    </html>
  );
}
