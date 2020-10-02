import { GET_PESSOAS, GET_PESSOA, DELETE_PESSOA } from "../actions/types";

const initialState = {
  pessoas: [],
  pessoa: {}
};

export default function(state = initialState, action) {
  switch (action.type) {
    case GET_PESSOAS:
      return {
        ...state,
        pessoas: action.payload
      };

    case GET_PESSOA:
      return {
        ...state,
        pessoa: action.payload
      };

    case DELETE_PESSOA:
      return {
        ...state,
        pessoas: state.pessoas.filter(
          pessoa => pessoa.id !== action.payload
        )
      };
    default:
      return state;
  }
}
