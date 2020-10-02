import React, { Component } from "react";
import { Link } from "react-router-dom";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { deletePessoa } from "../../actions/pessoasActions";

class PessoaItem extends Component {

  onDeleteClick = id => {
    this.props.deletePessoa(id);
  };

  render() {
    const { pessoa } = this.props;
    return (
      <div className="container">
        <div className="card card-body bg-light mb-3">
          <div className="row">
            <div className="col-2">
              <span className="mx-auto">{pessoa.id}</span>
            </div>
            <div className="col-lg-6 col-md-4 col-8">
              <h3>{pessoa.nome}</h3>
            </div>
            <div className="col-md-4 d-none d-lg-block">
              <ul className="list-group">                
                <Link to={`/updatePessoa/${pessoa.id}`}>
                  <li className="list-group-item update">
                    <i className="fa fa-edit pr-1"> Editar</i>
                  </li>
                </Link>

                <li
                  className="list-group-item delete"
                  onClick={this.onDeleteClick.bind(
                    this,
                    pessoa.id
                  )}
                >
                  <i className="fa fa-minus-circle pr-1"> Excluir Pessoa</i>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

PessoaItem.propTypes = {
  deletePessoa: PropTypes.func.isRequired
};

export default connect(
  null,
  { deletePessoa }
)(PessoaItem);
