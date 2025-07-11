'use client';
import { FaMouse } from 'react-icons/fa';
import Link from 'next/link';

export default function Home() {
  return (
    <div
      className="min-h-screen flex flex-col justify-center items-center text-white bg-cover bg-center bg-no-repeat px-4"
      style={{
        backgroundImage: "url('https://img.freepik.com/premium-photo/vibrant-esports-event-background-with-neon-game-controllers-futuristic-digital-elements_43969-62587.jpg?semt=ais_hybrid&w=740')", // 🔁 เปลี่ยน path ตามจริง
      }}
    >
      <div className="bg-black bg-opacity-60 p-8 rounded-xl shadow-lg text-center animate-fade-in-up">
        <FaMouse className="text-6xl text-blue-400 mb-4 animate-bounce" />
        <h1 className="text-5xl sm:text-6xl font-extrabold text-blue-300 drop-shadow-md tracking-wide">
          ★ ยินดีต้อนรับ ★
        </h1>
        <p className="text-lg sm:text-xl mt-2 text-gray-300 font-light">
          สู่ร้าน <span className="text-blue-400 font-semibold">เมาส์เกมมิ่ง</span> ระดับโปร!
        </p>

        {/* <Link
          href="/products"
          className="mt-6 inline-block bg-blue-600 hover:bg-blue-500 transition duration-300 px-6 py-3 rounded-full text-white font-semibold shadow-lg hover:scale-105"
        >
          เข้าสู่เมนูสินค้า
        </Link> */}

        <p className="mt-6 text-sm text-gray-400 italic">
          พบกับเมาส์สุดล้ำ ดีไซน์เท่ ฟังก์ชันครบ 💥
        </p>
      </div>
    </div>
  );
}
