import React, { useEffect, useState } from "react";
import { BASE_URL } from "../../Constants/Constant";
import axios from "axios";
import { useSelector } from "react-redux";
import CircularProgress from "@mui/material/CircularProgress";

function ApplyLoan() {
  const [loanType, setLoanType] = useState("");
  const [ammount, setAmmount] = useState("");
  const [roi, setRoi] = useState("");
  const [duration, setDuration] = useState("");
  const [course, setCourse] = useState("");
  const [fee, setFee] = useState("");
  const [income, setIncome] = useState("");
  const [father, setFather] = useState("");
  const [occupation, setOccupation] = useState("");
  const [company, setCompany] = useState("");
  const [designation, setDesignation] = useState("");
  const [totalExp, setTotalExp] = useState("");
  const [currExp, setCurrExp] = useState("");
  const [ammountErr, setAmmountErr] = useState("");
  const [loanTypeErr, setLoanTypeErr] = useState("");
  const [durationErr, setDurationErr] = useState("");
  const [incomeErr, setIncomeErr] = useState("");
  const [feeErr, setFeeErr] = useState("");
  const [totalExpErr, setTotalExpErr] = useState("");
  const [currExpErr, setCurrExpErr] = useState("");
  const user = useSelector((state) => state.auth.authDetails.user);
  const [successMsg, setSuccessMsg] = useState("");
  const [loader, setLoader] = useState(false);

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!ammount.match(/[0-9]+/)) {
      setAmmountErr("Enter Valid Ammount");
    } else if (Number(ammount) < 1000) {
      setAmmountErr("Ammount should be Greater than 1000");
    } else {
      setAmmountErr("");
    }

    if (loanType === "") {
      setLoanTypeErr("Select Loan Type");
    } else setLoanTypeErr("");

    if (duration === "") setDurationErr("Select Duration");
    else setDurationErr("");

    if (!income.match(/[0-9]+/)) {
      setIncomeErr("Enter Valid Income");
    } else if (Number(income) < 10000) {
      setIncomeErr(
        "You are not eligible for loan. Income should be greater than 10000"
      );
    } else {
      setIncomeErr("");
    }

    if (!fee.match(/[0-9]+/)) setFeeErr("Enter valid fees");
    else setFeeErr("");

    if (!totalExp.match(/[0-9]+/)) setTotalExpErr("Enter valid Experience");
    else setTotalExpErr("");

    if (!currExp.match(/[0-9]+/)) setCurrExpErr("Enter valid Experience");
    else setCurrExpErr("");

    let URL;
    let payload = {
      loanType: loanType,
      loanAmmount: Number(ammount),
      interest: roi,
      loanDate: new Date(),
      duration: Number(duration),
      annualIncome: Number(income),
      userId: user.user_Id,
    };

    if (
      loanType === "Education" &&
      ammount.match(/[0-9]+/) &&
      Number(ammount) >= 1000 &&
      loanType !== "" &&
      duration !== "" &&
      income.match(/[0-9]+/) &&
      Number(income) >= 10000 &&
      fee.match(/[0-9]+/)
    ) {
      URL = `${BASE_URL}/bank/addEducationLoan`;
      payload = {
        ...payload,
        courseFee: Number(fee),
        course: course,
        father: father,
        fatherOccupation: occupation,
      };
    } else if (
      (loanType === "Personal" || loanType === "Home") &&
      ammount.match(/[0-9]+/) &&
      Number(ammount) >= 1000 &&
      loanType !== "" &&
      duration !== "" &&
      income.match(/[0-9]+/) &&
      Number(income) >= 10000 &&
      totalExp.match(/[0-9]+/) &&
      currExp.match(/[0-9]+/)
    ) {
      URL = `${BASE_URL}/bank/addPersonalLoan`;
      payload = {
        ...payload,
        company: company,
        designation: designation,
        experience: Number(totalExp),
        expWithCurrentCompany: Number(currExp),
      };
    }

    setLoader(true);
    axios
      .post(URL, payload)
      .then((resp) => {
        if (resp.status === 201) {
          setSuccessMsg("Loan Application Submitted");
          setLoanType("");
          setAmmount("");
          setRoi("");
          setFee("");
          setDuration("");
          setIncome("");
          setCourse("");
          setFather("");
          setOccupation("");
          setCompany("");
          setDesignation("");
          setTotalExp("");
          setCurrExp("");
          setLoader(false);
        } else {
          alert("Something went wrong");
          setLoanType("");
          setAmmount("");
          setRoi("");
          setFee("");
          setDuration("");
          setIncome("");
          setCourse("");
          setFather("");
          setOccupation("");
          setCompany("");
          setDesignation("");
          setTotalExp("");
          setCurrExp("");
          setLoader(false);
        }
      })
      .catch((err) => {
        alert("Something went wrong");
        setLoanType("");
        setAmmount("");
        setRoi("");
        setFee("");
        setDuration("");
        setIncome("");
        setCourse("");
        setFather("");
        setOccupation("");
        setCompany("");
        setDesignation("");
        setTotalExp("");
        setCurrExp("");
        setLoader(false);
      });
  };
  return (
    <div>
      <div className="">
        <h2>Apply for Loan</h2>
        <div style={{ marginTop: "20px" }}>
          <form className="inner-div" onSubmit={handleSubmit}>
            <div className="input-container">
              <label htmlFor="loanType">Loan Type</label>
              <select
                name="loanType"
                id="loanType"
                onChange={(e) => {
                  setLoanType(e.target.value);
                  if (e.target.value === "") {
                    setRoi("");
                  } else if (e.target.value === "Education") {
                    setRoi(8);
                  } else {
                    setRoi(12);
                  }
                }}
                style={{ height: "35px" }}
              >
                <option value="">--Select Loan Type--</option>
                <option value="Personal">Personal</option>
                <option value="Education">Education</option>
                <option value="Home">Home</option>
              </select>
              <p
                className="error-msg"
                style={{ visibility: loanTypeErr === "" ? "hidden" : "" }}
              >
                {loanTypeErr}
              </p>
            </div>

            <div className="input-container">
              <label htmlFor="ammount">Loan Ammount</label>
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
              <label htmlFor="interest">Interest Rate</label>
              <input
                type="text"
                name="interest"
                id="interest"
                value={roi + "%"}
                required
                disabled
                // onChange={(e) => setFname(e.target.value)}
              />
              {/* <p
                className="error-msg"
                style={{ visibility: fnameErr === "" ? "hidden" : "" }}
              >
                {ammountErr}
              </p> */}
            </div>

            <div className="input-container">
              <label htmlFor="duration">Loan Duration</label>
              <select
                name="duration"
                id="duration"
                onChange={(e) => setDuration(e.target.value)}
                style={{ height: "35px" }}
              >
                <option value="">--Select Loan Duration--</option>
                <option value="5">5 Years</option>
                <option value="10">10 Years</option>
                <option value="15">15 Years</option>
                <option value="20">20 Years</option>
              </select>
              <p
                className="error-msg"
                style={{ visibility: durationErr === "" ? "hidden" : "" }}
              >
                {durationErr}
              </p>
            </div>
            {loanType === "Education" && (
              <>
                <div className="input-container">
                  <label htmlFor="fee">Course Fee</label>
                  <input
                    type="text"
                    name="fee"
                    id="fee"
                    value={fee}
                    required
                    onChange={(e) => setFee(e.target.value)}
                  />
                  <p
                    className="error-msg"
                    style={{ visibility: feeErr === "" ? "hidden" : "" }}
                  >
                    {feeErr}
                  </p>
                </div>

                <div className="input-container">
                  <label htmlFor="course">Course</label>
                  <input
                    type="text"
                    name="course"
                    id="course"
                    value={course}
                    required
                    onChange={(e) => setCourse(e.target.value)}
                  />
                  {/* <p
                className="error-msg"
                style={{ visibility: fnameErr === "" ? "hidden" : "" }}
              >
                {ammountErr}
              </p> */}
                </div>

                <div className="input-container">
                  <label htmlFor="father">Father Name</label>
                  <input
                    type="text"
                    name="father"
                    id="father"
                    value={father}
                    required
                    onChange={(e) => setFather(e.target.value)}
                  />
                  {/* <p
                className="error-msg"
                style={{ visibility: fnameErr === "" ? "hidden" : "" }}
              >
                {ammountErr}
              </p> */}
                </div>

                <div className="input-container">
                  <label htmlFor="occupation">Father Accupation</label>
                  <input
                    type="text"
                    name="occupation"
                    id="occupation"
                    value={occupation}
                    required
                    onChange={(e) => setOccupation(e.target.value)}
                  />
                  {/* <p
                className="error-msg"
                style={{ visibility: fnameErr === "" ? "hidden" : "" }}
              >
                {ammountErr}
              </p> */}
                </div>
              </>
            )}

            {loanType !== "" && loanType !== "Education" && (
              <>
                <div className="input-container">
                  <label htmlFor="company">Company Name</label>
                  <input
                    type="text"
                    name="company"
                    id="company"
                    value={company}
                    required
                    onChange={(e) => setCompany(e.target.value)}
                  />
                  {/* <p
                className="error-msg"
                style={{ visibility: fnameErr === "" ? "hidden" : "" }}
              >
                {ammountErr}
              </p> */}
                </div>

                <div className="input-container">
                  <label htmlFor="designation">Designation</label>
                  <input
                    type="text"
                    name="designation"
                    id="designation"
                    value={designation}
                    required
                    onChange={(e) => setDesignation(e.target.value)}
                  />
                  {/* <p
                className="error-msg"
                style={{ visibility: fnameErr === "" ? "hidden" : "" }}
              >
                {ammountErr}
              </p> */}
                </div>

                <div className="input-container">
                  <label htmlFor="totalExp">Total Experience (Yrs.)</label>
                  <input
                    type="text"
                    name="totalExp"
                    id="totalExp"
                    value={totalExp}
                    required
                    onChange={(e) => setTotalExp(e.target.value)}
                  />
                  <p
                    className="error-msg"
                    style={{ visibility: totalExpErr === "" ? "hidden" : "" }}
                  >
                    {totalExpErr}
                  </p>
                </div>

                <div className="input-container">
                  <label htmlFor="currExp">
                    Experience with Current company (Yrs.)
                  </label>
                  <input
                    type="text"
                    name="currExp"
                    id="currExp"
                    value={currExp}
                    required
                    onChange={(e) => setCurrExp(e.target.value)}
                  />
                  <p
                    className="error-msg"
                    style={{ visibility: currExpErr === "" ? "hidden" : "" }}
                  >
                    {currExpErr}
                  </p>
                </div>
              </>
            )}

            <div className="input-container">
              <label htmlFor="income">Annual Income</label>
              <input
                type="text"
                name="income"
                id="income"
                value={income}
                required
                onChange={(e) => setIncome(e.target.value)}
              />
              <p
                className="error-msg"
                style={{ visibility: incomeErr === "" ? "hidden" : "" }}
              >
                {incomeErr}
              </p>
            </div>
            {loader ? (
              <button className="signupBtn">
                <CircularProgress />
              </button>
            ) : (
              <button className="signupBtn">Apply</button>
            )}
          </form>
          <p style={{ color: "green" }}>{successMsg}</p>
        </div>
      </div>
    </div>
  );
}

export default ApplyLoan;
