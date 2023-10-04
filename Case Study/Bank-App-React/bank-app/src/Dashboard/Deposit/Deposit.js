import React, { useState } from "react";
import { BASE_URL } from "../../Constants/Constant";
import { useSelector } from "react-redux";
import axios from "axios";

function Deposit() {
  const [ammount, setAmmount] = useState("");
  const [ammountErr, setAmmountErr] = useState("");
  const user = useSelector((state) => state.auth.authDetails.user);
  const [successMsg, setSuccessMsg] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!ammount.match(/[0-9]+/)) {
      setAmmountErr("Enter Valid Ammount");
    } else if (Number(ammount) < 1000) {
      setAmmountErr("Ammount should be Greater than 1000");
    } else {
      setAmmountErr("");
    }

    if (ammount.match(/[0-9]+/) && Number(ammount) >= 1000) {
      const URL = `${BASE_URL}/user/depositMoney`;
      const payload = {
        user_Id: user.user_Id,
        money: Number(ammount),
      };
      axios.put(URL, payload).then((resp) => {
        if (resp.status === 200) {
          setSuccessMsg("Ammount deposited successfully");
        }
      });
    }
  };
  return (
    <div>
      <form onSubmit={handleSubmit}>
        <label htmlFor="ammount">Enter Ammount</label>
        <br />
        <input
          type="text"
          name="ammount"
          id="ammount"
          value={ammount}
          required
          onChange={(e) => {
            setAmmount(e.target.value);
            setAmmountErr("");
            setSuccessMsg("");
          }}
        />
        <p
          className="error-msg"
          style={{ visibility: ammountErr === "" ? "hidden" : "" }}
        >
          {ammountErr}
        </p>
        <button className="signupBtn">Deposit</button>
      </form>
      <p style={{ color: "green" }}>{successMsg}</p>
    </div>
  );
}

export default Deposit;
