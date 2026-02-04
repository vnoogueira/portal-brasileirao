import React, { useState } from "react";
import api from "../services/api";

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [erro, setErro] = useState("");

  console.log("Login component renderizado");

  const handleSubmit = async (e: any) => {
    e.preventDefault();
    console.log("Form submit disparado");
    setErro("");

    console.log("Tentando logar com", email, password);

    try {
      const response = await api.post("/auth/login", {
        email: email,
        password: password,
      });

      console.log("Resposta recebida", response.data);

      localStorage.setItem("token", response.data.token);
      console.log(localStorage.getItem("token"));
    } catch (err) {
      setErro("Credenciais inválidas");
    }
  };

  return (
    <form className="flex items-center justify-center min-h-screen bg-gray-100">
      <div
        onSubmit={handleSubmit}
        className="bg-white p-6 rounded shadow-md w-80"
      >
        <h2 className="text-xl font-bold mb-4">Login</h2>

        {erro && <p className="text-red-500 mb-2">{erro}</p>}

        <input
          type="email"
          placeholder="Email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          className="w-full mb-3 p-2 border rounded"
          required
        />

        <input
          type="password"
          placeholder="Senha"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          className="w-full mb-3 p-2 border rounded"
          required
        />

        <button
          type="button"
          className="w-full bg-blue-500 text-white p-2 rounded"
          onClick={handleSubmit}
        >
          Entrar
        </button>
      </div>
    </form>
  );
};

export default Login;
