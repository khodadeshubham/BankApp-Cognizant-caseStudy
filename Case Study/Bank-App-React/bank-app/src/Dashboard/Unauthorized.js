import React from "react";
import { useNavigate } from "react-router-dom";

function Unauthorized() {
  const navigate = useNavigate();
  const gotoLoginPage = () => navigate("/");

  return (
    <div
      style={{
        display: "flex",
        justifyContent: "center",
        marginTop: "15%",
        marginLeft: "20%",
      }}
    >
      <p>
        Access Denied. Please{" "}
        <span className="link" onClick={gotoLoginPage}>
          Login
        </span>
      </p>
    </div>
  );
}

export default Unauthorized;
