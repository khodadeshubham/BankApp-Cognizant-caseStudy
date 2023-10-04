export const setAuthDetails = (payload) => {
  return {
    type: "SET_AUTH_DETAILS",
    data: payload,
  };
};

export const logout = () => {
  return {
    type: "LOGOUT",
  };
};
