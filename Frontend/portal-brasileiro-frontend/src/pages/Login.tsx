import React, { useState } from "react";
import axios from "axios";

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [erro, setErro] = useState("");

  const handleSubmit = async (e: any) => {
    e.preventDefault();
    setErro("");

    try {
      const response = await axios.post("http://localhost:8081/auth/login", {
        email: email,
        password: password,
      });

      console.log(`login: ${email}`);

      console.log(`password: ${password}`);

      localStorage.setItem("token", response.data.token);
      window.location.href = "/dashboard";
    } catch (err) {
      setErro("Credenciais inválidas");
    }
  };

  return (
    <div className="flex items-center justify-center min-h-screen bg-gray-100">
      <form
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
          type="submit"
          className="w-full bg-blue-500 text-white p-2 rounded"
        >
          Entrar
        </button>
      </form>
    </div>
  );
};

export default Login;
