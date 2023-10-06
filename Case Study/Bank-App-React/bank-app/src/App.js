import logo from "./logo.svg";
import "./App.css";
import Login from "./Login/Login";
import { BrowserRouter, Route, Routes, useNavigate } from "react-router-dom";
import Register from "./Login/Register";
import { useSelector } from "react-redux";
import Dashboard from "./Dashboard/Dashboard";
import { useEffect } from "react";
import axios from "axios";

function App() {
  const authDetails = useSelector((store) => store.auth.authDetails);

  useEffect(() => {
    if (authDetails) {
      // const axios = axios.create({
      //   headers: {
      //     "Content-Type": "application/json", // You can add other common headers here
      //   },
      // });

      // Add an interceptor to set the authentication token before each request
      axios.interceptors.request.use(
        (config) => {
          // Set your authentication token here
          const authToken = authDetails.token; // Replace with your authentication token
          config.headers["Authorization"] = `Bearer ${authToken}`;
          return config;
        },
        (error) => {
          return Promise.reject(error);
        }
      );
    }
  }, [authDetails]);

  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/register" element={<Register />} />

          <Route path="/dashboard" element={<Dashboard />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
