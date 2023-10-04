import { applyMiddleware, createStore, combineReducers, compose } from "redux";
import thunk from "redux-thunk";
import { composeWithDevTools } from "redux-devtools-extension";
import { authReducer } from "./Reducer/AuthReducer";

const appReducer = combineReducers({
  auth: authReducer,
});

export const store = createStore(
  appReducer,
  composeWithDevTools(applyMiddleware(thunk))
);
