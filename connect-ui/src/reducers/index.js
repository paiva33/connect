import { combineReducers } from "redux";
import errorReducer from "./errorReducer";
import pessoaReducer from "./pessoaReducer";
import securityReducer from "./securityReducer";

export default combineReducers({
  errors: errorReducer,
  pessoa: pessoaReducer,  
  security: securityReducer
});
