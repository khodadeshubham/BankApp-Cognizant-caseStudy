import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import BankImage from "./../Images/BankImage.png";
import "../Login/Login.css";
import { BASE_URL } from "../Constants/Constant";
import { useDispatch, useSelector } from "react-redux";
import { setAuthDetails } from "../Store/Action/AuthAction";
import CircularProgress from "@mui/material/CircularProgress";

function Login() {
  const [userName, setUserName] = useState("");
  const [password, setPassword] = useState("");
  const [userNameError, setUserNameError] = useState("");
  const [passwordError, setPasswordError] = useState("error");
  const navigate = useNavigate();
  const dispatch = useDispatch();
  const isAuthenticated = useSelector((state) => state.auth.authDetails);
  const registered = sessionStorage.getItem("registrationDone");
  const [loader, setLoader] = useState(false);

  const handleSubmit = (e) => {
    e.preventDefault();

    var lowerCaseLetters = /[a-z]/g;
    var upperCaseLetters = /[A-Z]/g;
    var numbers = /[0-9]/g;

    if (
      !password.match(
        /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/
      )
    ) {
      setPasswordError("Please enter valid password");
      setPassword("");
    } else {
      setPasswordError("");
      const URL = `${BASE_URL}/user/login`;
      const payload = {
        userName,
        password,
      };
      setLoader(true);
      axios
        .post(URL, payload)
        .then((resp) => {
          if (resp.status !== 200) {
            setPasswordError("Invalid Username or Password");
          } else {
            dispatch(setAuthDetails(resp.data));
            sessionStorage.setItem("userDetails", JSON.stringify(resp.data));
            setUserName("");
            setPassword("");
            setLoader(false);
          }
        })
        .catch((error) => {
          setPasswordError("Invalid Username or Password");
          dispatch(setAuthDetails(null));
          setUserName("");
          setPassword("");
          setLoader(false);
        });
    }
  };

  useEffect(() => {
    if (isAuthenticated) navigate("/dashboard");
  }, [isAuthenticated]);

  const gotoSignUpPage = () => navigate("/register");
  return (
    <div className="login__container">
      <div className="login">
        <p
          style={{
            color: "green",
            visibility: registered === "true" ? "" : "hidden",
          }}
        >
          Account has been created. Please Log in
        </p>
        <h2>Login </h2>
        <form className="login__form" onSubmit={handleSubmit}>
          <label htmlFor="userName">User Name</label>
          <input
            type="text"
            id="userName"
            name="userName"
            value={userName}
            required
            onChange={(e) => {
              setUserName(e.target.value);
              setPasswordError("error");
            }}
          />
          <label htmlFor="password">Password</label>
          <input
            type="password"
            name="password"
            id="password"
            minLength={8}
            required
            value={password}
            onChange={(e) => {
              setPassword(e.target.value);
              setPasswordError("error");
            }}
          />
          <p
            style={{
              color: "red",
              visibility: passwordError === "error" ? "hidden" : "",
            }}
          >
            {passwordError}
          </p>
          {loader ? (
            <button className="loginBtn">
              <CircularProgress color="inherit" size={20} />
            </button>
          ) : (
            <button className="loginBtn">SIGN IN</button>
          )}
          <p>
            Don't have an account?{" "}
            <span className="link" onClick={gotoSignUpPage}>
              Create Account
            </span>
          </p>
        </form>
      </div>
      <div>
        <img src={BankImage} alt="logo" className="bank-image" />
      </div>
    </div>
  );
}

export default Login;
