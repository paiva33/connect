import React from "react";
import { Link } from "react-router-dom";

const CreatePessoaButton = () => {
  return (
    <React.Fragment>
      <Link to="/addPessoa" className="btn btn-lg btn-info">
        Criar Pessoa
      </Link>
    </React.Fragment>
  );
};

export default CreatePessoaButton;
