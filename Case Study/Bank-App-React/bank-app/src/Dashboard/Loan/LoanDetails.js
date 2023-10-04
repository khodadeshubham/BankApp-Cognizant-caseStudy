import React, { useEffect, useState } from "react";
import { BASE_URL } from "../../Constants/Constant";
import axios from "axios";
import { useSelector } from "react-redux";

function LoanDetails() {
  const [data, setData] = useState([]);
  const user = useSelector((state) => state.auth.authDetails.user);

  useEffect(() => {
    const URL = `${BASE_URL}/bank/getAllLoans/${user.user_Id}`;
    axios
      .get(URL)
      .then((resp) => {
        if (resp.data.length > 0) setData(resp.data);
        else setData([]);
      })
      .catch((err) => setData([]));
  }, []);

  console.log(data);
  return (
    <div>
      {data.length > 0 && (
        <table border="1">
          <thead>
            <tr>
              <th>Sr. No.</th>
              <th>Loan Date</th>
              <th>Loan Type</th>
              <th>Loan Ammount</th>
              <th>Interest Rate</th>
              <th>Loan Duration</th>
            </tr>
          </thead>
          <tbody>
            {data.map((loan, index) => {
              return (
                <tr>
                  <td>{++index}</td>
                  <td>{loan.loanDate}</td>
                  <td>{loan.loanType}</td>
                  <td>{loan.loanAmmount}</td>
                  <td>{loan.interest}</td>
                  <td>{loan.duration}</td>
                </tr>
              );
            })}
          </tbody>
        </table>
      )}
    </div>
  );
}

export default LoanDetails;
