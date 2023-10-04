import React, { useEffect, useState } from "react";
import { BASE_URL } from "../../Constants/Constant";
import { useSelector } from "react-redux";
import axios from "axios";
import "../Overview/Overview.css";

function Overview() {
  const userDetails = useSelector((state) => state.auth.authDetails);
  const [accountDetails, setAccountDetails] = useState();

  useEffect(() => {
    if (userDetails !== null) {
      const URL = `${BASE_URL}/user/userBankDetails/${userDetails.user.user_Id}`;
      axios
        .get(URL)
        .then((resp) => {
          console.log(resp.data);
          setAccountDetails(resp.data);
        })
        .catch((err) => setAccountDetails());
    }
  }, []);

  return (
    <>
      {accountDetails && (
        <div className="overview-details">
          <h3>Account Overview</h3>
          <div>
            <h4>Account Holder Name</h4>
            <p>{accountDetails.name}</p>
          </div>
          <div>
            <h4>Branch</h4>
            <p>{accountDetails.bankList[0].branch}</p>
          </div>
          <div>
            <h4>{accountDetails.bankList[0].accountType + " Account"}</h4>
            <p>{accountDetails.bankList[0].accountNumber}</p>
          </div>
          <div>
            <h4>Balance</h4>
            <p>{accountDetails.bankList[0].balance}</p>
          </div>
        </div>
      )}
    </>
  );
}

export default Overview;
