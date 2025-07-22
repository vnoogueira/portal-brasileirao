import React from 'react';
import { Link } from 'react-router-dom';

export default function Home() {
  return (
    <div className="p-4">
      <h1 className="text-2xl font-bold text-blue-600 mb-4">Portal Brasileiro - Home</h1>
      <button className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
        Clique Aqui
      </button>
      <div className="mt-6">
        <Link to="/login" className="text-blue-600 underline">
          Ir para Login
        </Link>
      </div>
    </div>
  );
}