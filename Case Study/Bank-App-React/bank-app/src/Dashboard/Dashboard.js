import React, { useState } from "react";
import Overview from "./Overview/Overview";
import Navbar from "./NavBar";
import "../Dashboard/Dashboard.css";
import Loan from "./Loan/LoanApply";
import Header from "./Header";
import Deposit from "./Deposit/Deposit";
import ApplyLoan from "./Loan/LoanApply";
import LoanDetails from "./Loan/LoanDetails";
import { useSelector } from "react-redux";
import Unauthorized from "./Unauthorized";

function Dashboard(props) {
  const [selectedOption, setSelectedOption] = useState("overview");
  const isAuthenticated = useSelector((store) => store.auth.authDetails);

  const renderComponent = () => {
    switch (selectedOption) {
      case "overview":
        return <Overview />;
      case "deposit":
        return <Deposit />;
      case "loanApply":
        return <ApplyLoan />;
      case "loanDetails":
        return <LoanDetails />;
      default:
        return <Overview />;
    }
  };

  const handleOptionChange = (option) => {
    setSelectedOption(option);
  };

  return (
    <>
      {isAuthenticated ? (
        <>
          <Header />
          <div className="dashboard-container">
            <Navbar
              selectedOption={selectedOption}
              onOptionChange={handleOptionChange}
            />
            <div
              className={
                selectedOption !== "loanApply"
                  ? "module-container"
                  : "module-container-loan"
              }
            >
              {renderComponent()}
            </div>
          </div>
        </>
      ) : (
        <div className="dashboard-container">
          <Unauthorized />
        </div>
      )}
    </>
  );
}

export default Dashboard;
