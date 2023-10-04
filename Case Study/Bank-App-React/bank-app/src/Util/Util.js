export const getInterestRate = (age) => {
  if (age < 18) return 6;
  else if (age >= 18 && age < 60) return 12;
  else return 8;
};
