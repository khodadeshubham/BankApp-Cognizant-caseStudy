import logo from "./logo.svg";
import "./App.css";
import Login from "./Login/Login";
import { BrowserRouter, Route, Routes, useNavigate } from "react-router-dom";
import Register from "./Login/Register";
import { useSelector } from "react-redux";
import Dashboard from "./Dashboard/Dashboard";
import { useEffect } from "react";

function App() {
  const isAuthenticated = useSelector((store) => store.auth.userLoggedIn);

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
