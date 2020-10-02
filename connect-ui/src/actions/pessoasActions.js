import axios from "axios";
import { GET_ERRORS, GET_PESSOA, GET_PESSOAS, DELETE_PESSOA } from "./types";

export const createProject = (project, history) => async dispatch => {
  try {
    await axios.post("/pessoas", project);
    history.push("/dashboard");
    dispatch({
      type: GET_ERRORS,
      payload: {}
    });
  } catch (err) {
    dispatch({
      type: GET_ERRORS,
      payload: err.response.data
    });
  }
};

export const getPessoas = () => async dispatch => {
  const res = await axios.get("/pessoas");
  dispatch({
    type: GET_PESSOAS,
    payload: res.data
  });
};

export const getPessoa = (id, history) => async dispatch => {
  try {
    const res = await axios.get(`/pessoas/${id}`);
    dispatch({
      type: GET_PESSOA,
      payload: res.data
    });
  } catch (error) {
    history.push("/dashboard");
  }
};

export const deletePessoa = id => async dispatch => {
  if (
    window.confirm(
      "Confirma exclusão?"
    )
  ) {
    await axios.delete(`/pessoas/${id}`);
    dispatch({
      type: DELETE_PESSOA,
      payload: id
    });
  }
};
