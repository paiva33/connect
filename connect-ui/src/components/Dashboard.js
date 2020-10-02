import React, { Component } from "react";
import PessoaItem from "./Pessoa/PessoaItem";
import CreatePessoaButton from "./Pessoa/CreatePessoaButton";
import { connect } from "react-redux";
import { getPessoas } from "../actions/pessoasActions";
import PropTypes from "prop-types";

class Dashboard extends Component {
  componentDidMount() {
    this.props.getPessoas();
  }

  render() {
    const { projects } = this.props.project;

    return (
      <div className="projects">
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              <h1 className="display-4 text-center">Pessoas</h1>
              <br />
              <CreatePessoaButton />

              <br />
              <hr />
              {projects.map(pessoa => (
                <PessoaItem key={pessoa.id} pessoa={pessoa} />
              ))}
            </div>
          </div>
        </div>
      </div>
    );
  }
}

Dashboard.propTypes = {
  pessoa: PropTypes.object.isRequired,
  getPessoas: PropTypes.func.isRequired
};

const mapStateToProps = state => ({
  pessoa: state.pessoa
});

export default connect(
  mapStateToProps,
  { getPessoas }
)(Dashboard);
