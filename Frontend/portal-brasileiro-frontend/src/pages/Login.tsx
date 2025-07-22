import React from 'react';
import { Link } from 'react-router-dom';

export default function Login() {
  return (
    <div className="p-4 max-w-md mx-auto">
      <h1 className="text-2xl font-bold mb-4">Login</h1>
      <p>Página de login em construção...</p>
      <div className="mt-6">
        <Link to="/" className="text-blue-600 underline">
          Voltar para Home
        </Link>
      </div>
    </div>
  );
}
