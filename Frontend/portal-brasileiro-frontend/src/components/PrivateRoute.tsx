import { ReactNode, useEffect, useState } from "react";
import { Navigate } from "react-router-dom";
import api from "../services/api";

interface PrivateRouteProps {
  children: ReactNode;
}

const PrivateRoute = ({ children }: PrivateRouteProps) => {
  const [isValid, setIsValid] = useState<boolean | null>(null);

  useEffect(() => {
    const validateToken = async () => {
      try {
        await api.get("/auth/validate");
        setIsValid(true);
      } catch (error) {
        localStorage.removeItem("token");
        setIsValid(false);
      }
    };

    validateToken();
  }, []);

  if (isValid === null) {
    return <p>Carregando...</p>;
  }

  return isValid ? children : <Navigate to="/login" />;
};

export default PrivateRoute;
