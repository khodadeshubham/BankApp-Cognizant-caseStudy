const initialState = {
  authDetails:
    sessionStorage.getItem("userDetails") === ""
      ? null
      : JSON.parse(sessionStorage.getItem("userDetails")),
  userLoggedIn: sessionStorage.getItem("userDetails") === "" ? false : true,
};

export const authReducer = (state = initialState, action) => {
  switch (action.type) {
    case "SET_AUTH_DETAILS":
      return {
        ...state,
        authDetails: action.data,
        userLoggedIn: action.data !== null ? true : false,
      };

    case "LOGOUT":
      return {
        ...state,
        authDetails: null,
        userLoggedIn: false,
      };

    default:
      return state;
  }
};
