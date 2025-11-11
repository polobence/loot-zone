import type { Metadata } from "next";
import "./globals.css";

export const metadata: Metadata = {
  title: "Loot Zone",
  description: "A treasure trove of digital goods",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body className="bg-gray-900 text-white">{children}</body>
    </html>
  );
}
