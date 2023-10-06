import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import validator from "validator";
import { BASE_URL } from "../Constants/Constant";
import CircularProgress from "@mui/material/CircularProgress";

const Register = () => {
  const [fname, setFname] = useState("");
  const [lname, setLname] = useState("");
  const [email, setEmail] = useState("");
  const [username, setUsername] = useState("");
  const [tel, setTel] = useState("");
  const [address, setAddress] = useState("");
  const [state, setState] = useState("");
  const [stateList, setStateList] = useState([]);
  const [countryList, setCountryList] = useState([]);
  const [country, setCountry] = useState("");
  const [dob, setDob] = useState("");
  const [accountType, setAccountType] = useState("");
  const [ammount, setAmmount] = useState("");
  const [document, setDocument] = useState("");
  const [docNumber, setDocNumber] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();
  const [userNameErr, setUserNameErr] = useState("");
  const [fnameErr, setFnameErr] = useState("");
  const [lnameErr, setLnameErr] = useState("");
  const [emailErr, setEmailErr] = useState("");
  const [contactErr, setContactErr] = useState("");
  const [passErr, setPassErr] = useState("");
  const [accountTypeErr, setAccountTypeErr] = useState("");
  const [docErr, setDocErr] = useState("");
  const [dobErr, setDobErr] = useState("");
  const [ammountErr, setAmmountErr] = useState("");
  const [branch, setBranch] = useState("");
  const [isValidated, setIsValidated] = useState(false);
  const [successMsg, setSuccessMsg] = useState(false);
  const [loader, setLoader] = useState(false);

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!fname.match(/^[a-zA-Z\s]+$/)) {
      setFnameErr("Enter valid name");
      setIsValidated(false);
    } else {
      setFnameErr("");
      setIsValidated(true);
    }

    if (!lname.match(/^[a-zA-Z\s]+$/)) {
      setLnameErr("Enter valid name");
      setIsValidated(false);
    } else {
      setLnameErr("");
      setIsValidated(true);
    }

    if (!validator.isEmail(email)) {
      setEmailErr("Enter valid email");
      setIsValidated(false);
    } else {
      setEmailErr("");
      setIsValidated(true);
    }

    if (!tel.match(/^\d{10}$/)) {
      setContactErr("Enter valid Contact Number");
      setIsValidated(false);
    } else {
      setContactErr("");
      setIsValidated(true);
    }

    if (
      !validator.isStrongPassword(password, {
        minLength: 8,
        minLowercase: 1,
        minUppercase: 1,
        minNumbers: 1,
        minSymbols: 1,
      })
    ) {
      setPassErr("Enter valid Password");
      setIsValidated(false);
    } else {
      setPassErr("");
      setIsValidated(true);
    }

    if (accountType === "") {
      setAccountTypeErr("Select Account Type");
      setIsValidated(false);
    } else {
      setAccountTypeErr("");
      setIsValidated(true);
    }

    if (document === "") {
      setDocErr("Select Document");
      setIsValidated(false);
    } else {
      setDocErr("");
      setIsValidated(true);
    }

    if (!ammount.match(/[0-9]+/)) {
      setAmmountErr("Enter Valid Ammount");
      setIsValidated(false);
    } else if (Number(ammount) < 1000) {
      setAmmountErr("Ammount should be Greater than 1000");
      setIsValidated(false);
    } else {
      setAmmountErr("");
      setIsValidated(true);
    }

    if (dob > new Date()) {
      setDobErr("Birthdate can not be greater than current date");
      setIsValidated(false);
    } else {
      setDobErr("");
      setIsValidated(true);
    }

    if (
      fname.match(/^[a-zA-Z\s]+$/) &&
      lname.match(/^[a-zA-Z\s]+$/) &&
      validator.isEmail(email) &&
      tel.match(/^\d{10}$/) &&
      validator.isStrongPassword(password, {
        minLength: 8,
        minLowercase: 1,
        minUppercase: 1,
        minNumbers: 1,
        minSymbols: 1,
      }) &&
      accountType !== "" &&
      document !== "" &&
      Number(ammount) > 1000 &&
      ammount.match(/[0-9]+/) &&
      new Date(dob) < new Date()
    ) {
      const data = {
        userName: username,
        name: fname + " " + lname,
        password: password,
        address: address,
        country: country,
        state: state,
        email: email,
        contact: tel,
        dob: dob,
        accountType: accountType,
        branch: branch,
        balance: ammount,
        document: document,
        documentNumber: docNumber,
      };

      const URL = `${BASE_URL}/user/register`;
      setLoader(true);
      axios
        .post(URL, data)
        .then((resp) => {
          if (resp.data) {
            setSuccessMsg(true);
            sessionStorage.setItem("registrationDone", true);
            setLoader(false);
          } else {
            setSuccessMsg("Account creation failed");
            sessionStorage.setItem("registrationDone", false);
            setLoader(false);
          }
        })
        .catch((err) => {
          setSuccessMsg("Account creation failed");
          sessionStorage.setItem("registrationDone", false);
          setLoader(false);
        });
    }
  };

  useEffect(() => {
    if (successMsg) navigate("/");
  }, [successMsg]);

  const getCitizenType = (dob) => {
    // Parse the input birthDate to a Date object
    const birthDateObj = new Date(dob);
    const currentDate = new Date();

    // Calculate the age
    const yearsDiff = currentDate.getFullYear() - birthDateObj.getFullYear();

    // Check if the birthdate has occurred this year
    if (
      currentDate.getMonth() < birthDateObj.getMonth() ||
      (currentDate.getMonth() === birthDateObj.getMonth() &&
        currentDate.getDate() < birthDateObj.getDate())
    ) {
      yearsDiff = yearsDiff - 1;
    }

    return yearsDiff;
  };

  function findUserName(userName) {
    const URL = `${BASE_URL}/user/checkUserPresence/${userName}`;
    if (userName !== "") {
      axios.get(URL).then((resp) => {
        if (resp.data === "") {
          setUserNameErr("");
        } else {
          setUserNameErr("User Name Already used.");
        }
      });
    }
  }
  const gotoLoginPage = () => navigate("/");

  return (
    <div>
      <div className="signup__container">
        <h2>Create Account </h2>
        <div style={{ marginTop: "20px" }}>
          <form className="inner-div" onSubmit={handleSubmit}>
            <div className="input-container">
              <label htmlFor="fname">First Name</label>
              <input
                type="text"
                name="fname"
                id="fname"
                value={fname}
                required
                onChange={(e) => setFname(e.target.value)}
              />
              <p
                className="error-msg"
                style={{ visibility: fnameErr === "" ? "hidden" : "" }}
              >
                {fnameErr}
              </p>
            </div>

            <div className="input-container">
              <label htmlFor="lname">Last Name</label>
              <input
                type="text"
                name="lname"
                id="lname"
                value={lname}
                required
                onChange={(e) => setLname(e.target.value)}
              />
              <p
                className="error-msg"
                style={{ visibility: lnameErr === "" ? "hidden" : "" }}
              >
                {lnameErr}
              </p>
            </div>

            <div className="input-container">
              <label htmlFor="email">Email Address</label>
              <input
                type="email"
                name="email"
                id="email"
                value={email}
                required
                onChange={(e) => setEmail(e.target.value)}
              />
              <p
                className="error-msg"
                style={{ visibility: emailErr === "" ? "hidden" : "" }}
              >
                {emailErr}
              </p>
            </div>
            <div className="input-container">
              <label htmlFor="tel">Phone Number</label>
              <input
                type="tel"
                name="tel"
                id="tel"
                value={tel}
                required
                onChange={(e) => setTel(e.target.value)}
              />
              <p
                className="error-msg"
                style={{ visibility: contactErr === "" ? "hidden" : "" }}
              >
                {contactErr}
              </p>
            </div>
            <div className="input-container">
              <label htmlFor="username">Username</label>
              <input
                type="text"
                id="username"
                name="username"
                value={username}
                required
                onChange={(e) => setUsername(e.target.value)}
                onBlur={(e) => findUserName(e.target.value)}
              />
              <p
                className="error-msg"
                style={{ visibility: userNameErr === "" ? "hidden" : "" }}
              >
                {userNameErr}
              </p>
            </div>

            <div className="input-container">
              <label htmlFor="tel">Password</label>
              <input
                type="password"
                name="password"
                id="password"
                minLength={8}
                required
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
              <p
                className="error-msg"
                style={{ visibility: passErr === "" ? "hidden" : "" }}
              >
                {passErr}
              </p>
            </div>
            <div className="input-container">
              <label htmlFor="address">Address</label>
              <input
                type="textarea"
                name="address"
                id="address"
                value={address}
                required
                onChange={(e) => setAddress(e.target.value)}
              />
            </div>
            <div className="input-container">
              <label htmlFor="state">State</label>
              <input
                type="text"
                name="state"
                id="state"
                value={state}
                required
                onChange={(e) => setState(e.target.value)}
              />
            </div>
            <div className="input-container">
              <label htmlFor="country">Country</label>
              <input
                type="text"
                name="country"
                id="country"
                value={country}
                required
                onChange={(e) => setCountry(e.target.value)}
              />
            </div>
            <div className="input-container">
              <label htmlFor="dob">Date of Birth</label>
              <input
                type="date"
                name="dob"
                id="dob"
                value={dob}
                required
                onChange={(e) => setDob(e.target.value)}
              />
              <p
                className="error-msg"
                style={{ visibility: dobErr === "" ? "hidden" : "" }}
              >
                {dobErr}
              </p>
            </div>
            <div className="input-container">
              <label htmlFor="accountType">Account Type</label>
              <select
                name="accountType"
                id="accountType"
                onChange={(e) => setAccountType(e.target.value)}
                style={{ height: "35px" }}
              >
                <option value="">--Select Account Type--</option>
                <option value="Saving">Saving</option>
                <option value="Current">Current</option>
              </select>
              <p
                className="error-msg"
                style={{ visibility: accountTypeErr === "" ? "hidden" : "" }}
              >
                {accountTypeErr}
              </p>
            </div>
            <div className="input-container">
              <label htmlFor="document">Document</label>
              <select
                name="document"
                id="document"
                onChange={(e) => setDocument(e.target.value)}
                style={{ height: "35px" }}
              >
                <option value="">--Select Document--</option>
                <option value="PAN">PAN Card</option>
                <option value="Aadhar">Aadhar Card</option>
              </select>
              <p
                className="error-msg"
                style={{ visibility: docErr === "" ? "hidden" : "" }}
              >
                {docErr}
              </p>
            </div>
            <div className="input-container">
              <label htmlFor="ammount">Initial Deposite Ammount</label>
              <input
                type="text"
                name="ammount"
                id="ammount"
                value={ammount}
                required
                onChange={(e) => setAmmount(e.target.value)}
              />
              <p
                className="error-msg"
                style={{ visibility: ammountErr === "" ? "hidden" : "" }}
              >
                {ammountErr}
              </p>
            </div>
            <div className="input-container">
              <label htmlFor="docNumber">Document Number</label>
              <input
                type="text"
                name="docNumber"
                id="docNumber"
                value={docNumber}
                required
                onChange={(e) => setDocNumber(e.target.value)}
              />
            </div>
            <div className="input-container">
              <label htmlFor="branch">Branch</label>
              <input
                type="text"
                name="branch"
                id="branch"
                value={branch}
                required
                onChange={(e) => setBranch(e.target.value)}
              />
            </div>
            {loader ? (
              <button className="signupBtn">
                <CircularProgress color="inherit" />
              </button>
            ) : (
              <button className="signupBtn">Create Account</button>
            )}
          </form>
          <p>
            Already have an account?{" "}
            <span className="link" onClick={gotoLoginPage}>
              Login
            </span>
          </p>
        </div>
      </div>
    </div>
  );
};

export default Register;
